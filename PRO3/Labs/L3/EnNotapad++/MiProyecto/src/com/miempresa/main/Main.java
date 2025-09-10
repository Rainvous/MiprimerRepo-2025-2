// El paquete donde se encuentra esta clase
package com.miempresa.main;

// Importar la clase Persona desde el paquete com.miempresa.personas
import com.miempresa.personas.Personas;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase Persona
        Personas p = new Personas("Juan");

        // Llamar al método saludar
        p.saludar();
    }
}
