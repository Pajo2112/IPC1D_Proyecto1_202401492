package proyecto1;

import java.io.FileWriter;
import java.io.IOException;
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

    public void guardarVentaEnArchivo() {
        try (FileWriter fw = new FileWriter("ventas.txt", true)) {
            fw.write(codigoProducto + "," + cantidad + "," + total + "," + fechaHora + "\n");
        } catch (IOException e) {
            System.out.println("Error guardando la venta.");
        }
    }
}