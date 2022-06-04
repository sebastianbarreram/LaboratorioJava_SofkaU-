# Solución propuesta por Sebastian Barrera Marín y Daniel Salinas Pinedo

Se realizó una aplicación para el juego de preguntas. Se utiliza un archivo de .txt para almacenar el historial de usuarios y un archivo .json 
para la letura de la base de datos de preguntas.

Para iniciar el juego se debe indicar primero el nombre del usuario por consola y luego dar al botón ENTER.
Para dar respuesta a cada pregunta se debe indicar por consola una única respuesta entre la A, B, C o D y luego pulsar ENTER para validar así su repuesta.
Puede salir del juego cuando desee ingresando por consola la letra x (equis) sin perder el acumulado de puntos.
Al finalizar se podrá vizualizar el nombre y el puntaje de los usuarios que han participado por consola.

## Funcionamiento de la aplicación

Se debe indicar en la variable link, que es de tipo String, la dirección de donde se quiere almacenar el archivo Historial.txt con el historial de usuarios 
en la línea 20 del archivo Operacion.java, ejemplo:
String link = "C:\\Users\\Acer\\Desktop\\LaboratorioJava_SofkaU-\\LaboratorioJava_SofkaU\\Historial.txt";.

Se debe indicar en la variable link, que es de tipo String, la dirección de donde se encuentra el archivo data.json, en la línea 21 del archivo Preguntas.java, 
ejemplo:
String link = "C:\\Users\\Acer\\Desktop\\LaboratorioJava_SofkaU-\\LaboratorioJava_SofkaU\\data.json";.

El elemento \ en los dos casos de link debe ser doble.

Para el buen funcionamiento de la aplicación se debe ejecutar el archivo Main.java en un entorno de desarrollo integrado (IDE) como por ejemplo con 
IntelliJ o un editor de código fuente como lo es Visual Studio Code.
