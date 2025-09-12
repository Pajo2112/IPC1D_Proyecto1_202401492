package proyecto1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        Bitacora bitacora = new Bitacora();
        Estudiante estudiante = new Estudiante("Tu Nombre", "Carnet", "Sección");

        int opcion;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Registrar venta");
            System.out.println("5. Generar reportes");
            System.out.println("6. Ver bitácora");
            System.out.println("7. Ver datos estudiante");
            System.out.println("8. Salir");
            System.out.print("Elija opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> inventario.agregarProducto();
                case 2 -> inventario.buscarProducto();
                case 3 -> inventario.eliminarProducto();
                case 4 -> inventario.registrarVenta();
                case 5 -> {
                    Reportes.generarReporteStock(inventario);
                    Reportes.generarReporteVentas();
                }
                case 6 -> bitacora.mostrarBitacora();
                case 7 -> estudiante.mostrarDatos();
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }
}
