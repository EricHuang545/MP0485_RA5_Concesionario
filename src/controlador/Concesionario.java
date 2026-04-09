/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;
import persistencia.FicheroVehiculos;

/**
 *
 * @author 芒果
 */
public class Concesionario {

    String ruta = System.getProperty("user.dir");
    FicheroVehiculos fichero = new FicheroVehiculos(ruta);
    private final List<Vehiculo> vehiculos = fichero.cargar();

    public void insertarVehiculo(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("El vehiculo insertado correctamente.");
        fichero.guardar(vehiculos);

    }

    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    public void eliminarVehiculo(String matricula) {
        Vehiculo v = buscarVehiculo(matricula);
        vehiculos.remove(v);
        fichero.guardar(vehiculos);
    }

    public List<Vehiculo> listarVehiculo() {
        return vehiculos;
    }
}
