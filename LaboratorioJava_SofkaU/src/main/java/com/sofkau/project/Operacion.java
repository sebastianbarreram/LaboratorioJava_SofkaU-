package com.sofkau.project;
import com.sofkau.project.objetos.Jugador;
import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Operacion {
    Jugador jugador = new Jugador();
    Logger logger = Logger.getLogger("logger");
    File f;
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;
    PrintWriter wr;
    int ronda = 1;
    private int respondida;
    private String link = "C:\\Users\\Acer\\Desktop\\LaboratorioJava_SofkaU-\\LaboratorioJava_SofkaU\\Historial.txt";
    Scanner scanner = new Scanner(System.in);

    public void inicio(JSONObject objeto){
        logger.info("Ingrese el usuario");
        String user = scanner.nextLine();
        if(!user.isEmpty()){
            jugador.setNombre(user);
            preguntas(objeto);
        }
        else{
            logger.info("Usuario incorrecto");
            System.exit(0);
        }
    }

    public void preguntas(JSONObject objeto){
        logger.info(()->
                "Escoja una respuesta, x para retirarte"+"\n"+
                        objeto.getString("pregunta")+"\n"+
                        "A) "+objeto.getString("respuesta1")+"\n"+
                        "B) "+objeto.getString("respuesta2")+"\n"+
                        "C) "+objeto.getString("respuesta3")+"\n"+
                        "D) "+objeto.getString("respuesta4")+"\n"
        );
        respondida = (scanner.nextLine().toUpperCase().charAt(0))-64;
        if(respondida > 0 && respondida < 5){
            ganaste(objeto);
        }else if(respondida == 24){
            retirar(respondida);
        }else{
            perdiste();
        }
    }

    private void retirar(int valor){
        try{
            if(valor == 24 && jugador.getPuntos() > 0){
                logger.info("¡Te has retirado!");
                persistir();
                System.exit(0);
            }
        }catch (IOException e){
            logger.info(()->"error"+e);
        }
    }

    private void ganaste(JSONObject objeto) {
        try{
            retirar(respondida);
            if(objeto.getString("respuesta"+objeto.getInt("correcta")).equals(objeto.getString("respuesta"+respondida))){
                if(ronda < 5){
                    ronda += 1;
                    logger.info("Respuesta Correcta");
                    jugador.addPuntos(jugador.getPuntos() + objeto.getInt("premio"));

                }else{
                    ronda += 1;
                    jugador.addPuntos(jugador.getPuntos() + objeto.getInt("premio"));
                    logger.info("Has completado todos los niveles, ¡Felicidades!");
                    persistir();
                }
            }else{
                perdiste();
            }
        }catch (IOException e){
            logger.info(()->"error"+e);
        }
    }

    public void persistir() throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;

        fichero = new FileWriter(link,true);
        pw = new PrintWriter(fichero);
        try {
            pw.println(jugador.getNombre() + ": " + jugador.getPuntos());
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
        mostrarHistorial();
    }

    public void mostrarHistorial() throws IOException {
        File archivo = null;
        try {
            archivo = new File(link);
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Lectura del fichero
            String linea;
            logger.info("Historial de usuarios:");
            while ((linea = bufferedReader.readLine()) != null){
                logger.info(linea);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            logger.info(()->"error "+e);
        }
    }

    private void perdiste(){
        logger.info("¡HAS PERDIDO!");
        ronda = 0;
        jugador.addPuntos(0);
        try{
            mostrarHistorial();
        }catch (IOException e){
            logger.info(()->"error "+e);
        }
        System.exit(0);
    }
}
