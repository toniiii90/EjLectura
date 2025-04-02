package OtroEjercicio;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        File lectura = new File("/home/antgarcla/ficheros/jugadores.txt");
        File escritura = new File("/home/antgarcla/ficheros/alojados.txt");


        Metodos.leerArchivo(lectura);
        Metodos.escribirArch(escritura);

    }
}

