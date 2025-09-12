package org.pavelcabrera.controller;
import org.pavelcabrera.model.Producto;
import org.pavelcabrera.model.Venta;
import org.pavelcabrera.model.Bitacora;

public class VentaController {
    private Venta[] ventas;
    private int contador;
    private Bitacora bitacora;

    public VentaController(Bitacora bitacora) {
        ventas = new Venta[100];
        contador = 0;
        this.bitacora = bitacora;
    }

    public void registrarVenta(Producto producto, int cantidad) {
        if (producto.getCantidad() >= cantidad) {
            double total = cantidad * producto.getPrecio();
            producto.setCantidad(producto.getCantidad() - cantidad);
            ventas[contador++] = new Venta(producto.getCodigo(), cantidad, total);
            bitacora.registrarAccion("Registrar venta", true);
        } else {
            bitacora.registrarAccion("Registrar venta", false);
        }
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public int getContador() {
        return contador;
    }
}