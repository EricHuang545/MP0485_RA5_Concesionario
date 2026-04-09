/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author 芒果
 */
public class FicheroVehiculos {

    private static String rutaArchivo;
    private String separador = File.separator;
    private String carpeta = rutaArchivo + separador + "data";
    private File carpetaNueva = new File(carpeta);
    private String archivo = carpeta + separador + "vehiculos.txt";
    private File archivoNuevo = new File(archivo);

    public FicheroVehiculos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void crearFichero() {
        try {
            if (!carpetaNueva.exists()) {
                carpetaNueva.mkdir();
            }

            if (!archivoNuevo.exists()) {
                archivoNuevo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void guardar(List<Vehiculo> vehiculos) {
        try {
            FileWriter fw = new FileWriter(archivoNuevo, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Vehiculo v : vehiculos) {
                bw.write(v.toString());
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public List<Vehiculo> cargar() {
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        try {
            FileReader fr = new FileReader(archivoNuevo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] vehiculo = linea.split(";");
                lista.add(new Vehiculo(vehiculo[0], vehiculo[1], vehiculo[2], Double.parseDouble(vehiculo[3]), vehiculo[4]
                ));
            }
            br.close();
            return lista;

        } catch (IOException e) {
            System.out.println("Error");
        }
        return lista;
    }
}
