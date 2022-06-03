package com.sofkau.project;

import java.io.*;
import java.util.HashMap;

public class Preguntas {
    private HashMap<String, String> preguntasDict = new HashMap<String, String>();

    public void cargarDatos() {
        try {
            String archivo = "./data.txt";
            File f = new File(archivo);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String[] lineaPartida = linea.split(":");
                String clave = lineaPartida[0];
                String valor = lineaPartida[1];
                this.preguntasDict.put(clave, valor);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }

    }

    public HashMap<String, String> getPreguntasDict() {
        return preguntasDict;
    }
}
