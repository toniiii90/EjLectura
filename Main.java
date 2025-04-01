package OtroEjercicio;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String archivoEntrada = "jugadores.txt";
        String salida = "alojados.txt";

        ArrayList<String> jugadores = new ArrayList<>();

        try {
            // Archivo de entrada
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));

            // Archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(salida));

            // Título en el archivo de salida
            bw.write("-----Lista de jugadores que se alojan en el hotel-----");
            bw.write("-----Ranking        Nombre\n");

            String linea;

            // Leo la primera línea y la descarto al no tener datos
            br.readLine();

            // Leemos línea por línea el archivo jugadores.txt
            while ((linea = br.readLine()) != null) {
                // Divido la línea en campos usando ;
                String[] campos = linea.split(";");

                // Aquí compruebo si el último campo es H de alojado
                if (campos.length >= 8 && campos[7].equals("H")) {
                    // Obtengo ránking inicial y nombre del jugador (columna 1 y columna 3)
                    String ranking = campos[0];
                    String nombre = campos[2];

                    jugadores.add(String.format("%-4s -- %s", ranking, nombre));
                }
            }
            br.close(); // Cierro el lector de archivos

            Collections.sort(jugadores); // Ordeno el arraylist

            // Con un bucle for, escribo los jugadores alojados en el archivo de salida
            for (String jugador : jugadores) {
                bw.write(jugador + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
