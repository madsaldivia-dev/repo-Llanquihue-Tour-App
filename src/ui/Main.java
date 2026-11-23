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

        // Muestra todos los tours cargados desde el archivo.
        obtenerTours();

        System.out.println("**********************************");

        // Muestra los tours filtrados por rango de precio.
        filtrarToursPorRango();
    }


    /**
     * Obtiene y muestra todos los tours registrados.
     */
    private static void obtenerTours() {

        // Crea una instancia de GestorDatos para acceder
        GestorDatos gestor = new GestorDatos("resources/Tours.txt");

        // Obtiene la lista completa de tours.
        ArrayList<Tour> tours =
                gestor.listarTour("resources/Tours.txt");

        if (!tours.isEmpty()) {

            System.out.println("=== TODOS LOS TOURS ===");

            // Recorre la lista completa de tours y muestra
            // la información de cada uno utilizando el método toString().
            for (Tour tour : tours) {
                System.out.println(tour);
            }
        } else {
            System.out.println("No existen tours registrados");
        }
    }

    private static void filtrarToursPorRango() {
        GestorDatos gestor = new GestorDatos("resources/Tours.txt");
        int precioMinimo = 10000;
        int precioMaximo = 20000;

        ArrayList<Tour> toursFiltrados = gestor.buscarToursPorRangoPrecio(precioMinimo, precioMaximo);


        if ((!toursFiltrados.isEmpty())) {

            System.out.println("=== TOURS ENTRE $" + precioMinimo + " Y $" + precioMaximo + " ===");
            for (Tour tour : toursFiltrados) {
                System.out.println(tour);
            }

        } else {
            System.out.println("No se encontraron tours en ese rango de precio.");
        }

    }
}


