package org.pavelcabrera.controller;

import org.pavelcabrera.model.Producto;
import org.pavelcabrera.model.Bitacora;

public class InventarioController {
    private Producto[] productos;
    private int contador;
    private Bitacora bitacora;

    public InventarioController(Bitacora bitacora) {
        productos = new Producto[100];
        contador = 0;
        this.bitacora = bitacora;
    }

    public void agregarProducto(Producto producto) {
        if (contador < productos.length) {
            productos[contador++] = producto;
            bitacora.registrarAccion("Agregar producto", true);
        } else {
            bitacora.registrarAccion("Agregar producto", false);
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getContador() {
        return contador;
    }
}