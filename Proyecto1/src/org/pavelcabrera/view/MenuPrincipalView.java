package org.pavelcabrera.view;
import org.pavelcabrera.controller.*;
import org.pavelcabrera.model.*;
import org.pavelcabrera.system.Ventana;

import java.util.Scanner;

public class MenuPrincipalView implements Ventana {
    private InventarioController inventarioController;
    private VentaController ventaController;
    private ReporteController reporteController;
    private BitacoraController bitacoraController;
    private Estudiante estudiante;
    private Scanner sc;

    public MenuPrincipalView() {
        Bitacora bitacora = new Bitacora();
        inventarioController = new InventarioController(bitacora);
        ventaController = new VentaController(bitacora);
        reporteController = new ReporteController(bitacora);
        bitacoraController = new BitacoraController(bitacora);
        estudiante = new Estudiante("Pavel Cabrera", "202401492", "D");
        sc = new Scanner(System.in);
    }

    @Override
    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Registrar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Generar reportes");
            System.out.println("6. Ver bitácora");
            System.out.println("7. Ver datos estudiante");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    Producto p = new Producto(codigo, nombre, categoria, precio, cantidad);
                    inventarioController.agregarProducto(p);
                }
                case 2 -> {
                    Producto[] productos = inventarioController.getProductos();
                    for (int i = 0; i < inventarioController.getContador(); i++) {
                        System.out.println(productos[i]);
                    }
                }
                case 3 -> {
                    System.out.print("Código del producto: ");
                    String codigo = sc.nextLine();
                    Producto[] productos = inventarioController.getProductos();
                    for (int i = 0; i < inventarioController.getContador(); i++) {
                        if (productos[i].getCodigo().equals(codigo)) {
                            System.out.print("Cantidad a vender: ");
                            int cantidad = sc.nextInt();
                            sc.nextLine();
                            ventaController.registrarVenta(productos[i], cantidad);
                        }
                    }
                }
                case 4 -> {
                    Venta[] ventas = ventaController.getVentas();
                    for (int i = 0; i < ventaController.getContador(); i++) {
                        System.out.println(ventas[i]);
                    }
                }
             case 5 -> {
    reporteController.generarReporteStockPDF(inventarioController.getProductos(), inventarioController.getContador());
    reporteController.generarReporteVentasPDF(ventaController.getVentas(), ventaController.getContador());
    reporteController.generarBitacoraPDF();
                }
                case 6 -> bitacoraController.mostrarBitacora();
                case 7 -> estudiante.mostrarDatos();
                case 8 -> System.out.println("👋 Saliendo...");
                default -> System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 8);
    }

    /**
     *
     */
    @Override
    public void ocultar() {
        System.out.println("Cerrando menú...");
    }
}
