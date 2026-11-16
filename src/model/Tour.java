package model;


/**
 * Clase que representa un tour turístico.
 * Almacena información básica como el nombre,
 * tipo de experiencia y precio del tour.
 */
public class Tour {

    private String nombre;
    private String tipo;
    private int precio;

    /**
     * Constructor vacío.
     * Permite crear un objeto Tour sin inicializar
     * sus atributos inmediatamente.
     */
    public Tour() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre nombre del tour.
     * @param tipo categoría o tipo del tour.
     * @param precio valor del tour.
     */
    public Tour(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Devuelve una representación en texto
     * de los datos del tour.
     *
     * @return información formateada del tour.
     */
    @Override
    public String toString() {
        return """
               ===== TOUR =====
               Nombre: %s
               Tipo: %s
               Precio: $%d
               =================
               """.formatted(nombre, tipo, precio);
    }
}
