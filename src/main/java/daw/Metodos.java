/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Metodos {

    //Leer fichero
    public static List<String> leerFichero() {
        String nombreFichero = "leer.txt";
        //Creamos una lista para almacenar la que nos devolvera ReadAllLines
        List<String> lista = new ArrayList<>();
        //Importante usar un try para controlar una posible excepcion
        try {
            lista = Files.readAllLines(Paths.get(nombreFichero));
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + nombreFichero);
        }
        lista.remove(0);
        return lista;
    }

    //Leer devolver matriz de una lista
    public static int[][] devolver(List<String> lista) {
        int[][] matriz = new int[lista.size()][6];
        for (int i = 0; i < matriz.length; i++) {
            String[] temporal = lista.get(i).split("\\s");
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Integer.parseInt(temporal[j]);
            }
        }
        return matriz;
    }

    //Método para ver matriz
    public static void verMatriz(int[][] matriz) {
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                System.out.print(matriz1[j] + "  ");
            }
            System.out.println();
        }
    }

    //Vamos a pasar de una matriz de int a una lista
    public static int[] listaSumatoria(int[][] matriz) {
        //Creamos el listado de Map
        int[] listado = new int[matriz.length];
        int acumulador = 0;
        //Obtenemos los datos
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 1; j < matriz[i].length; j++) {
                acumulador += matriz[i][j];
            }
            //Si las sumatoria es mayor al número especificado, registra error
            if(matriz[i][0]-acumulador<0){
                listado[i]=-1;
            }
            listado[i] = matriz[i][0] - acumulador;
            acumulador = 0;
        }
        return listado;
    }

    //Método para escribir un fichero
    public static void generarFicheroADevolver(int[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                Files.write(Paths.get("resultado.txt"), (array[i] + "\n").getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.out.println("Error creando el fichero");
            }
        }
    }
    
    //Método para leer
    public static void leer() {
        String idFichero="resultado.txt";
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split("\n");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
