package com.sofkau.project;

import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Preguntas {

    private JSONArray datos;

    private String link = "C:\\Users\\Acer\\Desktop\\LaboratorioJava_SofkaU-\\LaboratorioJava_SofkaU\\";

    private Random random = new Random();

    public void cargarDatos() throws IOException {
        String archivo = "data.json";
        String data = new String(Files.readAllBytes(Paths.get(this.link + archivo)));

        // leer como un json array
        this.datos = new JSONArray(data);
        for (int i = 0; i < this.datos.length(); i++) {
            // llevarlo a un json object
            String str = this.datos.get(i).toString();
            JSONObject object1 = new JSONObject(str);

            // String name = Integer.toString(object1.getInt("categoria"));
            // String age = object1.getString("pregunta");
            // System.out.println("pregunta: " + name);

            // System.out.println("Respuesta: " + age);
            /*
             * System.out.println(i);
             */
        }

    }

    public JSONObject preguntaAleatoria(int nivel) {
        int auxiliar = 0;

        int valorAleatorio = this.random.nextInt(4)+2;
        for (int i = 0; i < this.datos.length(); i++) {
            String str = this.datos.get(i).toString();
            JSONObject object1 = new JSONObject(str);
            int categoria = object1.getInt("categoria");
            //System.out.println("categoria"+categoria);
            // System.out.println("nivel-1"+(nivel));
            
            if (categoria == (nivel)) {
                //System.out.println(str);
                auxiliar += 1;
            }
            // System.out.println("valorAleatorio"+valorAleatorio);
            // System.out.println("auxiliar"+auxiliar);
            
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
