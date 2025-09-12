package proyecto1;

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;
    private String codigo;

    // Constructor
    public Producto(String nombre, String categoria, double precio, int cantidad, String codigo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public String getCodigo() { return codigo; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (" + categoria + ") Q" + precio + " Stock: " + cantidad;
    }
}

