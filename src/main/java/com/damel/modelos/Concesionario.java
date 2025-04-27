/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.modelos;

import com.damel.validaciones.Validaciones;
import java.util.TreeSet;

/**
 * Clase Concesionario<br>
 * Contiene los metodos que permiten gestionar el concesionario<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025<br><br>
 *
 * @author Borja Piñero
 */
public class Concesionario {
    
    // Uso un TreeSet para ordenar los vehículos por matricula
    private TreeSet<Vehiculo> vehiculosAlmacenados;

    /**
     * Crea el concesionario, un TreeSet que contendrá los vehiculos
     */
    public Concesionario() {
        this.vehiculosAlmacenados = new TreeSet<>();
    }
    
    /**
     * Metodo que devuelve el número de vehiculos que hay en el concesonario,
     * mediante el metodo size().
     * @return Devuelve el numero de vehiculos que contiene el concesionario
     * @see {@link java.util.TreeSet#size()}
     */
    public int getNumVehiculos() {
        return vehiculosAlmacenados.size();
    }
    
    /**
     * Metodo que busca un vehículo en el concesionario por matrícula.
     * 
     * @param matricula La matricula que se busca
     * @return Devuelve el vehiculo si existe en el concesionario, o null si no 
     * se encuentra en él.
     */
    public Vehiculo buscarVehiculo(String matricula){ // Nuevo metodo para buscar vehiculos
        
        for (Vehiculo vehiculo : vehiculosAlmacenados){
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }
    
    /**
     * Metodo que inserta un vehiculo en el concesionario, siempre que
     * la matricula no exista en el concesionario - 
     * {@link Validaciones#matriculaEsUnica(com.damel.modelos.Vehiculo, com.damel.modelos.Concesionario) }
     * 
     * @param nuevoVehiculo Los datos del vehiculo
     * @return devuelve {@code  false} si la matricula ya existe en el concesionario<br>
     * devuelve {@code true} si el vehiculo se añade corretamente
     */
    public boolean insertarVehiculo(Vehiculo nuevoVehiculo) { // Ahora este metodo es boolean
        
        // La primera condición ya no es necesaria, porque no hay exceso de vehiculos
        
        if (!Validaciones.matriculaEsUnica(nuevoVehiculo, this)) {
            return false;
        }
        
        // La ultima tampoco, ya que no tengo que aumentar el contador
        
        // Devuelvo directamente si se añade el vehiculo 
        return vehiculosAlmacenados.add(nuevoVehiculo);
    }

    /**
     * Método que busca un vehiculo en el concesionario, a partir de la matricula
     * 
     * @param matricula La matricula a buscar
     * @return Devuelve {@code null} si el vehiculo no existe en el concesionario
     * y una {@code String} con los datos del vehículo en caso de que exista.
     */
    public String buscaVehiculo(String matricula) {
        
        Vehiculo vehiculo = buscarVehiculo(matricula);
        
        if (vehiculo != null) {
            return vehiculo.toString();
        }
        return null;
    }

    /**
     * Método que muestra una lista con todos los vehiculos del concesonario
     * 
     * @return Devuelve una lista con todos los vehiculos del concesionario
     */
    public String listaVehiculos() {

        StringBuilder lista = new StringBuilder();

        lista.append("Vehiculos en el concesionario:\n");
        
        int i = 1;

        for (Vehiculo vehiculo : vehiculosAlmacenados) {
            lista.append("Vehiculo ")
                    .append(i++)
                    .append("\n")
                    .append(vehiculo.toString())
                    .append("\n          ***\n");
        }

        return lista.toString();
    }

    /**
     * Método que modifica los kilómetros de un vehiculo
     * 
     * @param matricula La matrícula del coche que queremos modificar
     * @param nuevoKm El nuevo valor de los kilómetros
     * @return Devuelve {@code 0} si se actualizan correctamente y {@code -1} si 
     * no existe el vehículo
     */
    public int modificarKm(String matricula, double nuevoKm) {
        
        Vehiculo vehiculo = buscarVehiculo(matricula);
        
        if (vehiculo != null) {
            vehiculo.setKm(nuevoKm);
            return 0;
        }
        return -1;
    }
    /**
     * Método para eliminar un vehículo del concesionario. Seleccionando una 
     * matrícula, busca el vehiculo, lo elimina y recorre todos los vehiculos 
     * del concesionario una posición hacia atrás.
     * 
     * @param matricula La matrícula que queremos eliminar
     * @return Devuelve una {@code Sring} con el error de que no existe el vehiculo
     * u otra con el mensaje de eliminado correctamente
     */
    public String eliminarVehiculo(String matricula) {
        Vehiculo vehiculo = buscarVehiculo(matricula);
        
        if (vehiculo == null) {
            return "Error: El vehiculo con matricula " +matricula +" no existe.";
        }
        
        vehiculosAlmacenados.remove(vehiculo);
        
        return "El vehiculo con matricula " +matricula +" se ha eliminado correctamente";
        
    }
}