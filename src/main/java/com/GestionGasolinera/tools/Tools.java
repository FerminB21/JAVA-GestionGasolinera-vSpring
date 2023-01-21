package com.GestionGasolinera.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.UUID;

public class Tools {
	
	public static Scanner scanner = new Scanner(System.in);

	public static int ShowMenu() {
        System.out.println("\n\n\n\n\n\n\t\t\t╔══════════════════════════════════════╗");
        System.out.println("\t\t\t║ Opciones de la Gasolinera                  ║");
        System.out.println("\t\t\t╠════════════════════════════════════════════╣");
        System.out.println("\t\t\t║ 1) Respostaje con Ticket                   ║");
        System.out.println("\t\t\t║ 2) Repostaje con Factura                   ║");
        System.out.println("\t\t\t║ 3) Ver todos los repostajes                ║");
        System.out.println("\t\t\t║ 4) Importe total del combustible vendido   ║");
        System.out.println("\t\t\t║ 5) Llenado de depósito                     ║");
        System.out.println("\t\t\t║ 6) Eliminar el último llenado de depósito  ║");
        System.out.println("\t\t\t║ 7) Ver todos los llenados de depósito      ║");
        System.out.println("\t\t\t║                                            ║");
        System.out.println("\t\t\t║ 0) Salir                                   ║");
        System.out.println("\t\t\t║                                            ║");
        System.out.println("\t\t\t╚════════════════════════════════════════════╝");
        
        return capturaEntero("Introduzca una opción del menú", 0, 7);
    }
	
	public static int capturaEntero(String mensaje, int min, int max) {
		int num = 0;
		boolean numOk = false;
		String input = null;
		
		do {
			System.out.print("\n\n" + mensaje + ":\t");
			input = scanner.next();
			numOk = tryParseInt(input, num);
			
			if (!numOk) {
				System.out.println("\n\n\\tError. El dato introducido no es un valor numérico.");
			}
			else if (num < min || num > max) {
				System.out.println("\n\n\tError. Esa opción no se encuentra en el menú.");
				numOk = false;
			}	
		} while(!numOk);
		
		return num;
	}
	
	public static boolean tryParseInt(String input, int num) {
		boolean numOk = false;
		
		try {
			num = Integer.parseInt(input);
			numOk = true;
		} catch (NumberFormatException ex) {
		    numOk = false;
		}
		
		return numOk;
	}
	
	public static UUID generarUUID() {	
		UUID uuid = UUID.randomUUID();
	    return uuid;
	}
	
	public static boolean preguntaSiNo(String pregunta) throws IOException {
		String tecla;
		
		do {
			System.out.print("\n\n" + pregunta + " (s=Sí; n=No):");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			tecla = bufferedReader.readLine();
			
			if (tecla == "s" || tecla == "S")
				return true;
			if (tecla == "n" || tecla == "N")
				return false;
			
			// si llega aquí es que no ha pulsado ninguna de las teclas correctas
			System.out.println("\n\n[ERROR]: Por favor, responde S o N");
			
		} while (true);
	}
	
	public static void pararPrograma() {
		System.out.println("\n\nPulse Intro para finalizar el programa.");
		scanner.next();
	}
	
}