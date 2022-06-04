package com.sofkau.project;

import java.io.IOException;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws IOException {
        Preguntas preguntas = new Preguntas();
        preguntas.cargarDatos();
        // System.out.println("datos:");
        // System.out.println(preguntas.getDatos().get(1).toString());
        JSONObject objeto= preguntas.preguntaAleatoria(3);
        System.out.println(objeto.getString("pregunta"));
        System.out.println(objeto.getInt("categoria"));
        System.out.println(objeto.getString("respuesta1"));
        System.out.println(objeto.getString("respuesta2"));
        System.out.println(objeto.getString("respuesta3"));
        System.out.println(objeto.getString("respuesta4"));
        System.out.println(objeto.getInt("correcta"));
        System.out.println(objeto.getInt("premio"));
        //System.out.println(preguntas.preguntaAleatoria(1));
        //System.out.println(preguntas.preguntaAleatoria(1).getString("pregunta"));
        // String age = object1.getString("pregunta");
        // System.out.println(age);

       operacion objOperacion=new operacion();
       objOperacion.persistir();
       objOperacion.mostrarHistorial();
       


    }
}