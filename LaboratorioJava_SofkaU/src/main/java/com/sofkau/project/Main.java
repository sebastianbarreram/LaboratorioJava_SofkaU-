package com.sofkau.project;


public class Main {
    public static void main(String[] args) {
        Preguntas preguntas=new Preguntas();
        preguntas.cargarDatos();
        System.out.println(preguntas.getPreguntasDict());

        System.out.println("Hello world!");
    }
}