package com.sofkau.project;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Logger;

public class Preguntas {
    private Logger logger = Logger.getLogger("logger");
    private JSONArray datos;

    private Random random = new Random();

    public void cargarDatos(){
        try{
            String link = "C:\\Calculadora\\LaboratorioJava_SofkaU-\\LaboratorioJava_SofkaU\\";
            String archivo = "data.json";
            String data = new String(Files.readAllBytes(Paths.get(link + archivo)));

            // leer como un json array
            this.datos = new JSONArray(data);
        }catch (IOException e){
            logger.info(()->"Error "+e);
        }
    }

    public JSONObject preguntaAleatoria(int nivel) {
        int auxiliar = 0;
        cargarDatos();
        int valorAleatorio = this.random.nextInt(4)+2;
        for (int i = 0; i < this.datos.length(); i++) {
            String str = this.datos.get(i).toString();
            JSONObject object1 = new JSONObject(str);
            int categoria = object1.getInt("categoria");
            if (categoria == (nivel)) {
                auxiliar += 1;
            }
            if (valorAleatorio == auxiliar) {
                return new JSONObject(this.datos.get(i).toString());
            }
        }
        return null;
    }

    public JSONArray getDatos() {
        return datos;
    }

}
