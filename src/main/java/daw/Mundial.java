/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.util.List;

/**
 *
 * @author victor
 */
public class Mundial {

    public static void main(String[] args) {
        //Obtenemos la lista del fichero
        List<String> lista = Metodos.leerFichero();
        lista.forEach(System.out::println);
       
        //De la lista obtenemos una matriz
        int[][] matriz = Metodos.devolver(lista);
        //La mostramos
        System.out.println("Mostramos la matriz de int generada"
                + "por el método a partir de la lista ");
        Metodos.verMatriz(matriz);
        
        //Devolvemos de esa matriz un int[] con los resultados
       int[]listado = Metodos.listaSumatoria(matriz);
        System.out.println("Mostramos el array de int para ver que esta bien");
        for (int i : listado) {
            System.out.println(i); 
        }
        
        //Generamos un fichero llamado resultado.txt con la informacion
        Metodos.generarFicheroADevolver(listado);
        //Lo enseñamos para comprobarlo
        System.out.println("Leemos el fichero..");
        Metodos.leer();
    }
}