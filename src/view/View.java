package view;

import model.logic.Modelo;

public class View 
{
		public void printMenu()
		{
			System.out.println("1. Cargar Datos");
		}
		
		public void printNumEdgesAndVer(String edges, String ver){
			System.out.println("El numero de arcos es: " + edges);
			System.out.println("El numero de vertices es: " + ver);
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		
}
