package org.pavelcabrera.model;

public class Producto {
    private String codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, String categoria, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + categoria + " | Q" + precio + " | Stock: " + cantidad;
    }
}
