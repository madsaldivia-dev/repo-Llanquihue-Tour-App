package ui;

import data.GestorDatos;
import model.Tour;

import java.util.ArrayList;

/**
 * Clase principal del programa.
 * Se encarga de cargar los tours desde un archivo de texto
 * y mostrarlos por pantalla.
 */
public class Main {

    /**
     * Método principal del programa.
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        obtenerTours();
    }

    private static void obtenerTours() {
        // Crea una instancia de GestorDatos para acceder
        // al método que carga los tours desde el archivo.
        GestorDatos gestor = new GestorDatos();

        // Carga todos los tours almacenados en el archivo
        // "Tours.txt" y los guarda en un ArrayList.
        ArrayList<Tour> tours =
                gestor.cargarTours("resources/Tours.txt");

        System.out.println("=== TODOS LOS TOURS ===");

        // Recorre la lista completa de tours y muestra
        // la información de cada uno utilizando el método toString().
        for (Tour tour : tours) {
            System.out.println(tour);
        }

        System.out.println("\n=== TOURS SOBRE $20.000 ===");

        // Recorre nuevamente la lista de tours.
        for (Tour tour : tours) {

            // Recorre nuevamente la lista de tours.
            if (tour.getPrecio() > 20000) {
                System.out.println(tour);
            }
        }
    }
}
