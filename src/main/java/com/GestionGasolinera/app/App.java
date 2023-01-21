package com.GestionGasolinera.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.GestionGasolinera.queries.ICombustibleQuery;
import com.GestionGasolinera.services.CombustibleServiceImpl;
import com.GestionGasolinera.services.ICombustibleService;
import com.GestionGasolinera.tools.Tools;


@Controller("App")
public class App {

	public static void main(String[] args) throws Exception {

		// inicializamos el contexto de spring (spring.ctx.xml)
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./META-INF/spring.ctx.xml"); 
		ICombustibleQuery combustibleQueryImpl = applicationContext.getBean(ICombustibleQuery.class);
		
		ICombustibleService combustibleService = new CombustibleServiceImpl();
		combustibleService.crearUnNuevoCombustible(combustibleQueryImpl);
		combustibleService.mostrarListaDeCombustibles(combustibleQueryImpl);
		
		int opcion = 0;
		
		do {
			System.out.flush();
			opcion = Tools.ShowMenu();
			System.out.flush();
			
			switch (opcion) {
				case 0:
					System.out.println("\n\n\tHa elegido la opción 0 de salir.");
					break;
				
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				case 7:
					break;
			}
			
		} while (opcion != 0);
		
		Tools.pararPrograma();
	}

}