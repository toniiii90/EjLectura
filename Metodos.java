package OtroEjercicio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Metodos {
    static List<Jugador> jugadoresHotel = new ArrayList<>();
    public static void leerArchivo(File archivo) {
        try {
            FileReader fr = null;
            fr = new FileReader(archivo);
            BufferedReader entrada = new BufferedReader(fr);
            String cadena = entrada.readLine();
            System.out.println("Lista de jugadores\n" + "Ranking Inicial -- Nombre");
            while (cadena != null) {
                String[] datos = cadena.split(";");
                if (datos.length > 7 && datos[7].contains("H")) {
                    Jugador jugador = new Jugador(datos[0], datos[2]);
                    System.out.println(jugador);
                    jugadoresHotel.add(jugador);
                }
                cadena = entrada.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: No se ha encontrado el archivo.");
        }
    }

    public static void escribirArch(File archivo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            writer.write("Jugadores que se alojan en el hotel:\n");
            for (Jugador jugador : jugadoresHotel) {
                writer.write(jugador.toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error: No se pudo escribir en el archivo.");
        }
    }
}

