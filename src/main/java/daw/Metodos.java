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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Metodos {

    //Leer fichero
    public static List<String> leerFichero(){
        String nombreFichero = "leer.txt";
        //Creamos una lista para almacenar la que nos devolvera ReadAllLines
        List<String> lista = new ArrayList<>();
        //Importante usar un try para controlar una posible excepcion
        try{
            lista = Files.readAllLines(Paths.get(nombreFichero));
        }catch(IOException ex){
            System.out.println("Error accediendo a " + nombreFichero);
        }
        return lista;
    }
    
    //Método para sumar
    //Leer fichero
    public static List<Integer> devolver(List<String> lista){
       String[][] matrizString = new String[3][lista.size()-1];
       List<Integer> listaFinal = new ArrayList();
       
       return listaFinal;
    }
    
    // Escribe un String a un fichero, sobreescribiendo si existe
    public static void escribirString(String nombreFichero) {
        Scanner teclado = new Scanner(System.in);
        String entrada = " ";

        do {
            System.out.println("¿Qué deseas escribir?");
            entrada = teclado.nextLine();
            if (!entrada.equalsIgnoreCase("fin")) {
                try {
                    Files.write(Paths.get(nombreFichero), (entrada + "\n").getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Error creando el fichero");
                }
            }
        } while (!entrada.equalsIgnoreCase("fin"));
    }
}