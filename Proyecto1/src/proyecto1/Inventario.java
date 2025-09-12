package proyecto1;

import java.util.Scanner;

public class Inventario {
    private Producto[] productos;
    private int contador;
    private Scanner sc;

    public Inventario() {
        productos = new Producto[100]; // máximo 100 productos
        contador = 0;
        sc = new Scanner(System.in);
    }

    public void agregarProducto() {
        // Pedir datos
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Categoría: ");
        String categoria = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        // Validar código único
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                System.out.println("Error: código repetido.");
                return;
            }
        }

        productos[contador] = new Producto(nombre, categoria, precio, cantidad, codigo);
        contador++;
        System.out.println("Producto agregado.");
    }

    public void buscarProducto() {
        System.out.print("Buscar por código/nombre/categoría: ");
        String criterio = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(criterio) ||
                productos[i].getNombre().equalsIgnoreCase(criterio) ||
                productos[i].getCategoria().equalsIgnoreCase(criterio)) {
                System.out.println(productos[i]);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontró producto.");
    }

    public void eliminarProducto() {
        System.out.print("Código a eliminar: ");
        String codigo = sc.nextLine();
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j+1];
                }
                contador--;
                System.out.println("Producto eliminado.");
                return;
            }
        }
        System.out.println("No existe producto con ese código.");
    }

    public void registrarVenta() {
        System.out.print("Código producto: ");
        String codigo = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                if (productos[i].getCantidad() >= cantidad) {
                    double total = cantidad * productos[i].getPrecio();
                    productos[i].setCantidad(productos[i].getCantidad() - cantidad);

                    Venta venta = new Venta(codigo, cantidad, total);
                    venta.guardarVentaEnArchivo();

                    System.out.println("Venta realizada. Total Q" + total);
                    return;
                } else {
                    System.out.println("Stock insuficiente.");
                    return;
                }
            }
        }
        System.out.println("Producto no encontrado.");
    }
}
