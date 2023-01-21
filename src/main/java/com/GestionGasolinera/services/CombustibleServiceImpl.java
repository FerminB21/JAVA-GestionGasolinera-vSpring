package com.GestionGasolinera.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.queries.ICombustibleQuery;
import com.GestionGasolinera.tools.Tools;


@Service("CombustibleServiceImpl")
public class CombustibleServiceImpl implements ICombustibleService {

	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);
	

	
	/**
	 * Mostrar lista de combustibles.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarListaDeCombustibles(ICombustibleQuery combustibleQueryImpl) throws Exception {
		List<Combustible> listaCombustibles = combustibleQueryImpl.listarCombustibles();
		
		for (Combustible combustible : listaCombustibles) {
			System.out.println(combustible.toString());
		}
	}
	
	
	
	/**
	 * Mostrar un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception {
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles(combustibleQueryImpl);
		
		int combustible_id = Tools.capturaEntero("\n\nIntroduzca un número para mostrar un combustible", 0, 2);
		Combustible combustible = combustibleQueryImpl.buscarCombustiblePorId(combustible_id);
		System.out.println(combustible.toString());
	}
	

	
	/**
	 * Seleccionar un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @return the combustible
	 * @throws Exception the exception
	 */
	@Override
	public Combustible seleccionarUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception {
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles(combustibleQueryImpl);
		
		int combustible_id = Tools.capturaEntero("\n\nIntroduzca un número para seleccionar un combustible", 0, 2);
		Combustible combustible = combustibleQueryImpl.buscarCombustiblePorId(combustible_id);
		
		return combustible;
	}
	

	
	/**
	 * Crear un nuevo combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	@Override
	public void crearUnNuevoCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception {
		System.out.print("\n\nIntroduzca el nombre del nuevo combustible:\t");
		String combustible_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca el precio del nuevo combustible:\t");
		double combustible_precio = scanner.nextDouble();
		
		combustibleQueryImpl.insertarCombustible(new Combustible(combustible_nombre, combustible_precio));
		System.out.println("\n\nEl nuevo combustible " + combustible_nombre + " se ha creado correctamente");
	}
	
	
	
	/**
	 * Editar nombre ø precio de un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	@Override
	public void editarNombreØPrecioDeUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception {
		System.out.print("\n\nVamos a editar los datos de un combustible");
		Combustible combustible = seleccionarUnCombustible(combustibleQueryImpl);
		
		System.out.print("\n\nIntroduzca un nuevo nombre para el combustible seleccionado:\t");
		String combustible_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca el nuevo precio para el combustible seleccionado:\t");
		double combustible_precio = scanner.nextDouble();
		
		combustibleQueryImpl.editarCombustible(combustible.getCombustible_id(), combustible_nombre, combustible_precio);
		System.out.println("\n\nEl combustible selecccionado se ha modificado correctamente");
	}

	
	
	/**
	 * Eliminar un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception {
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles(combustibleQueryImpl);
		
		Combustible combustible = seleccionarUnCombustible(combustibleQueryImpl);
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el combustible seleccionado ?")) {
			combustibleQueryImpl.eliminarCombustible(combustible);
			System.out.println("\n\nEl combustible seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl combustible seleccionado NO se ha eliminado");
		}
	}

	

	/**
	 * Eliminar un combustible por id.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnCombustiblePorId(ICombustibleQuery combustibleQueryImpl) throws Exception {
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles(combustibleQueryImpl);
		
		int combustible_id = Tools.capturaEntero("\n\nIntroduzca un número para eliminar ese combustible", 0, 2);
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el combustible seleccionado ?")) {
			combustibleQueryImpl.eliminarCombustiblePorId(combustible_id);
			System.out.println("\n\nEl combustible seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl combustible seleccionado NO se ha eliminado");
		}
	}
	
}
