package org.pavelcabrera.model;

import java.time.LocalDateTime;

public class Bitacora {
    private String[] registros;
    private int contador;

    public Bitacora() {
        registros = new String[200];
        contador = 0;
    }

    public void registrarAccion(String accion, boolean exito) {
        if (contador < registros.length) {
            registros[contador++] = LocalDateTime.now() + " | " + accion + " | " + (exito ? "OK" : "ERROR");
        }
    }

    public String[] getRegistros() {
        return registros;
    }

    public int getContador() {
        return contador;
    }
}