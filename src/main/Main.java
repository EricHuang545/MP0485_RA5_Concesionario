/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.Concesionario;
import java.io.File;
import java.io.IOException;
import persistencia.FicheroVehiculos;
import vista.VentanaPrincipal;

/**
 *
 * @author 芒果
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rutaArchivo = System.getProperty("user.dir");
        FicheroVehiculos fichero = new FicheroVehiculos(rutaArchivo);
        fichero.crearFichero();
        java.awt.EventQueue.invokeLater(() -> {
            Concesionario c = new Concesionario();
            VentanaPrincipal v = new VentanaPrincipal(c);
            v.mostrarMenu();
        });
    }
    
}
