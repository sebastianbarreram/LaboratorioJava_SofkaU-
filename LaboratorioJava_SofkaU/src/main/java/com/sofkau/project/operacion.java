package com.sofkau.project;

//import com.sofkau.project.abstracts.LoggerAbstract;
//import com.sofkau.project.objetos.Jugador;
import org.json.JSONObject;

import java.io.*;
//import java.util.Scanner;
//import java.util.logging.Logger;

public class operacion extends Preguntas {
    // Jugador jugador = new Jugador();
    File f;
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;
    PrintWriter wr;
    private int ronda = 1;

    String link = "C:\\Users\\Acer\\Desktop\\LaboratorioJava_SofkaU-\\LaboratorioJava_SofkaU\\Historial.txt";

    // JSONObject objeto = preguntaAleatoria(ronda);

    // private void Ganaste(){
    // if(objeto.getString("respuesta"+objeto.getInt("correcta")) == ){
    // if(ronda < 5){
    // ronda += 1;
    // logger.info("Respuesta Correcta");
    // jugador.addPuntos(5*ronda);
    // //Preguntas();
    // }else{
    // ronda += 1;
    // jugador.addPuntos(5*ronda);
    // logger.info("Has completado todos los niveles, ¡Felicidades!");
    // Persistir();
    // }
    // }
    // }

    // Para persistir el Score
    public void persistir() throws IOException {
        String nombre = "sebas";
        int puntuacion = 60;
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        fichero = new FileWriter(this.link,true);
        pw = new PrintWriter(fichero);
        try {
            pw.println(nombre + ": " + puntuacion);
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    public void mostrarHistorial() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(this.link);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            //System.out.println("Historial de usuarios:");
            while ((linea = br.readLine()) != null)
                linea=br.readLine();
                //System.out.println(linea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }




    // private void Perdiste(){
    // logger.info("¡HAS PERDIDO!");
    // ronda = 0;
    // jugador.addPuntos(0);
    // }
}
