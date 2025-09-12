package proyecto1;

public class Bitacora {
    private String[] registros;
    private int contador;

    public Bitacora() {
        registros = new String[100];
        contador = 0;
    }

    public void registrarAccion(String accion) {
        if (contador < registros.length) {
            registros[contador] = accion;
            contador++;
        }
    }

    public void mostrarBitacora() {
        System.out.println("Bitácora:");
        for (int i = 0; i < contador; i++) {
            System.out.println(registros[i]);
        }
    }
}
