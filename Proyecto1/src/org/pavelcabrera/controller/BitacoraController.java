
package org.pavelcabrera.controller;
import org.pavelcabrera.model.Bitacora;

public class BitacoraController {
    private Bitacora bitacora;

    public BitacoraController(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public void mostrarBitacora() {
        System.out.println("\n--- BITÁCORA ---");
        for (int i = 0; i < bitacora.getContador(); i++) {
            System.out.println(bitacora.getRegistros()[i]);
        }
    }
}
