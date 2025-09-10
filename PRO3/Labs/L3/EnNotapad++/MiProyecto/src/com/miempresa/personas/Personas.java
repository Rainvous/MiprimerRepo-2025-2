// El paquete donde se encuentra esta clase
package com.miempresa.personas;

public class Personas {
    private String nombre;

    // Constructor
    public Personas(String nombre) {
        this.nombre = nombre;
    }

    // Método para saludar
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre);
    }
}
