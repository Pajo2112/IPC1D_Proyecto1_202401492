package org.pavelcabrera.model;

public class Estudiante {
    private String nombre;
    private String carnet;
    private String seccion;

    public Estudiante(String nombre, String carnet, String seccion) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.seccion = seccion;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Carnet: " + carnet);
        System.out.println("Sección: " + seccion);
    }
}