package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar la lectura de datos
 * desde archivos externos.
 */
public class GestorDatos {


    /**
     * Carga los tours almacenados en un archivo de texto.
     *
     * @param ruta ruta del archivo que contiene la información de los tours.
     * @return lista de objetos Tour cargados desde el archivo.
     */
    public ArrayList<Tour> cargarTours(String ruta) {

        // Lista donde se almacenarán todos los tours leídos.
        ArrayList<Tour> tours = new ArrayList<>();

        // Intenta abrir y leer el archivo indicado.
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            // Recorre el archivo hasta llegar al final.
            while ((linea = br.readLine()) != null) {

                // Divide los datos de la línea utilizando ";" como separador.
                String[] datos = linea.split(";");

                String nombre = datos[0];
                String tipo = datos[1];
                int precio = Integer.parseInt(datos[2]);

                Tour tour = new Tour(nombre, tipo, precio);

                tours.add(tour);
            }

        } catch (Exception e) {

            // Muestra un mensaje en caso de error durante la lectura.
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        return tours;
    }
}
