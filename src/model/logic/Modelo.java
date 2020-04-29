package model.logic;

import com.google.gson.Gson;
import controller.Controller;
import model.data_structures.*;
import view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;



public class Modelo {

	private Controller controller;

	private static View view;

	//Valor inicial para el nï¿½mero de datos a cargar
	public int N;

	/*
	 * Grande = ./data/Comparendos_DEI_2018_Bogotï¿½_D.C.geojson
	 * Mediano Ordenado = ./data/Comparendos_DEI_2018_Bogotï¿½_D.C_small_50000_sorted.geojson
	 * Mediano = ./data/Comparendos_DEI_2018_Bogotï¿½_D.C_50000_.geojson
	 * pequenio = ./data/Comparendos_DEI_2018_Bogotï¿½_D.C_small.geojson
	 */
	private static final String GRANDE = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";
	private static final String MEDIANOORDENADO = "./data/Comparendos_DEI_2018_Bogotá_D.C_small_50000_sorted.geojson";
	private static final String MEDIANO = "./data/Comparendos_DEI_2018_Bogotá_D.C_50000_.geojson";
	private static final String PEQUENIO = "./data/Comparendos_DEI_2018_Bogotá_D.C_small.geojson";


	public static int mayorOID;

	@SuppressWarnings("rawtypes")
	private static ArbolRojoNegro arbol;
	private static String archivoActual;
	private static MaxCola colaPQ;


	public Modelo(){
		N = 20;
		view = new View();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void cargar(){

		arbol = new ArbolRojoNegro();

		//cambiar esto para cambiar de tamanio de archivos.
		archivoActual = MEDIANO;
		try
		{
			FileInputStream inputStream;
			inputStream = new FileInputStream(archivoActual);
			InputStreamReader inputStreamreader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamreader);

			Json cargar =  new Gson().fromJson(bufferedReader, Json.class);


			for (int i=0; i<cargar.features.length;i++){
				Comparendo comp = new Comparendo(cargar.features[i].properties.OBJECTID, cargar.features[i].properties.FECHA_HORA,
						cargar.features[i].properties.MEDIO_DETECCION,cargar.features[i].properties.CLASE_VEHICULO,
						cargar.features[i].properties.TIPO_SERVICIO,cargar.features[i].properties.INFRACCION,
						cargar.features[i].properties.DES_INFRACCION,cargar.features[i].properties.LOCALIDAD,
						cargar.features[i].properties.MUNICIPIO,cargar.features[i].geometry.coordinates[0],
						cargar.features[i].geometry.coordinates[1],"OBJECTID");

				arbol.put(comp.darLlave(), comp);

			}

		}
		catch (Exception e)
		{
			e.getStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static void requerimientosCargar(){
		Comparendo maximo = (Comparendo) arbol.get(arbol.max());
		view.mensajeDeCarga(arbol.size() +"", maximo.toString());
	}


	//clases del Json para cargar

	private static class Json{
		String type;
		Features[] features;
	}

	private static class Features{
		String type;
		Properties properties;
		Geometry geometry;
	}

	private static class Geometry{
		String type;
		double[] coordinates;
	}

	private static class Properties{
		int OBJECTID;
		String FECHA_HORA;
		String MEDIO_DETECCION;
		String CLASE_VEHICULO;
		String TIPO_SERVICIO;
		String INFRACCION;
		String DES_INFRACCION;
		String LOCALIDAD;
		String MUNICIPIO;
	}


}