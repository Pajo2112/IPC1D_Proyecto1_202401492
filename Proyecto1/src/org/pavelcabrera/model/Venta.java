package org.pavelcabrera.model;

import java.time.LocalDateTime;

public class Venta {
    private String codigoProducto;
    private int cantidad;
    private double total;
    private String fechaHora;

    public Venta(String codigoProducto, int cantidad, double total) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.total = total;
        this.fechaHora = LocalDateTime.now().toString();
    }

    public String getCodigoProducto() { return codigoProducto; }
    public int getCantidad() { return cantidad; }
    public double getTotal() { return total; }
    public String getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        return fechaHora + " | " + codigoProducto + " | Cantidad: " + cantidad + " | Total: Q" + total;
    }
}