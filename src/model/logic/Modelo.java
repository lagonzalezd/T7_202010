package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import controller.Controller;
import model.data_structures.EstacionArco;
import model.data_structures.EstacionVertice;
import view.View;

public class Modelo {

	private Controller controller;
	
	private EstacionVertice vert;
	private EstacionArco arc;

	private static View view;

	public Modelo(){
		view = new View();
	}
	
	public void cargar() throws IOException
	{
		int aarcos=0;
		int avertices=0;

		String rutaVertices="./data/bogota_vertices.txt";
		String rutaArcos="./data/bogota_arcos.txt";
		try{
			FileReader reader = new FileReader(rutaArcos);
			BufferedReader lector = new BufferedReader( reader );
			
			String linea = lector.readLine( );
			while(linea!=null)
			{
				String[] partes = linea.split( " " );
				aarcos++;
				for (int i = 1; i<partes.length;i++) {
					arc = new EstacionArco(Integer.parseInt(partes[0]),Integer.parseInt(partes[i]),0);
				}
				linea=lector.readLine();
			}
			reader.close( );
			lector.close( );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try{
			FileReader reader = new FileReader(rutaVertices);
			BufferedReader lector = new BufferedReader( reader );   
			String linea = lector.readLine( );
			while(linea!=null)
			{
				String[] partes = linea.split(",");
				int id = Integer.parseInt(partes[0]);
				double longitud = Double.parseDouble(partes[1]);
				double latitud = Double.parseDouble(partes[2]);
				vert = new EstacionVertice(id, longitud, latitud);
				avertices++;
				linea=lector.readLine();
			}
			lector.close( );
			reader.close( );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		view.printNumEdgesAndVer(avertices + "", aarcos + "");
	}

	public void crearJson() {

    }
	public void leerJson(){
	}

}