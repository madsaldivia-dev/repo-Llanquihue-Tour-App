package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar la lectura de datos
 * desde archivos externos.
 */
public class GestorDatos {

    // Lista donde se almacenan los tours cargados desde el archivo.
    private ArrayList <Tour> tours = new ArrayList<>();

    public GestorDatos(String ruta){
        tours = cargarTours(ruta );

    }

    /**
     * Carga los tours almacenados en un archivo de texto.
     *
     * Formato esperado:
     * nombre;tipo;precio
     *
     * @param ruta ruta del archivo que contiene la información de los tours.
     * @return lista de objetos Tour cargados desde el archivo.
     */
    public ArrayList <Tour> cargarTours(String ruta) {

        // Limpia la lista para evitar duplicados si se vuelve a cargar.
        tours.clear();


        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            // Recorre el archivo hasta llegar al final.
            while ((linea = br.readLine()) != null) {

                if(linea.isBlank()){
                    continue;
                }

                // Divide los datos de la línea utilizando ";" como separador.
                String[] datos = linea.split(";");

                if (datos.length !=3){
                    System.out.println("Linea invalida" + linea);
                    continue;

                }

                try {

                    String nombre = datos[0];
                    String tipo = datos[1];
                    int precio = Integer.parseInt(datos[2]);

                    // Validación: precio debe ser positivo.
                    if (precio <= 0) {
                        System.out.println("Precio inválido en línea: " + linea);
                        continue;
                    }

                    // Crea el objeto Tour y lo agrega a la lista.
                    Tour tour = new Tour(nombre, tipo, precio);
                    tours.add(tour);

                }catch (NumberFormatException e){
                    System.out.println("Precio invalido en linea:" + linea);

                }
            }

        } catch (IOException e) {

            // Muestra un mensaje en caso de error durante la lectura.
            System.out.println("Error al leer archivo: " + e.getMessage());

        }
        return tours;
    }

    /**
     * Retorna la lista completa de tours cargados.
     *
     * @param rutaArchivos parámetro no utilizado.
     * @return lista de tours.
     */
    public ArrayList <Tour> listarTour(String rutaArchivos){
        return tours;
    }

    /**
     * Busca tours dentro de un rango de precios.
     *
     * @param precioMinimo precio mínimo.
     * @param precioMaximo precio máximo.
     * @return lista de tours que cumplen el criterio.
     */
    public ArrayList<Tour> buscarToursPorRangoPrecio (int precioMinimo,
                                                      int precioMaximo){

        ArrayList<Tour> toursFiltrados = new ArrayList<>();

        // Recorre todos los tours cargados.
        for (Tour tour : tours){

            if (tour.getPrecio() >= precioMinimo && tour.getPrecio() <= precioMaximo){

                toursFiltrados.add(tour);
            }
        }
        return toursFiltrados;
    }
}
