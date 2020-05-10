package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import controller.Controller;
import model.data_structures.EstacionArco;
import model.data_structures.EstacionVertice;
import model.data_structures.GrafoNoDirigido;
import view.View;

public class Modelo {

	private GrafoNoDirigido<Integer, EstacionVertice> graph;

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
		graph = new GrafoNoDirigido<>(228046);
		String rutaVertices="./data/bogota_vertices.txt";
		String rutaArcos="./data/bogota_arcos.txt";
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
				graph.addVertex(id, vert);
				avertices++;
				linea=lector.readLine();
			}
			lector.close( );
			reader.close( );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			FileReader reader = new FileReader(rutaArcos);
			BufferedReader lector = new BufferedReader( reader );

			String linea = lector.readLine( );
			while(linea!=null)
			{
				String[] partes = linea.split( " " );
				for (int i = 1; i<partes.length;i++) {
					aarcos++;
					graph.addEdge(Integer.parseInt(partes[0]), Integer.parseInt(partes[i]), 0);
				}
				linea=lector.readLine();
			}
			reader.close( );
			lector.close( );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		view.printNumEdgesAndVer(avertices + "", aarcos + "");
	}

	public void createJson() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("./data/informacion.json")) {
            gson.toJson(graph, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void readJson(){
		Gson gson = new Gson();
		String path = "./data/informacion.json";
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(path));
			graph = gson.fromJson(reader, EstacionVertice.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}