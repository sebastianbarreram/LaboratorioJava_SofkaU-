package com.sofkau.project;
import org.json.JSONObject;

public class Iniciar {
    Operacion operacion = new Operacion();
    Preguntas preguntas = new Preguntas();

    public void juego(){
        JSONObject objeto = preguntas.preguntaAleatoria(operacion.ronda);
        operacion.inicio(objeto);
        do{
            objeto = preguntas.preguntaAleatoria(operacion.ronda);
            preguntas.preguntaAleatoria(operacion.ronda);
            operacion.preguntas(objeto);
        }while(operacion.ronda < 6);
    }
}
