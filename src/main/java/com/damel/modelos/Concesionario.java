/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.modelos;

import com.damel.validaciones.Validaciones;

/**
 * Clase Concesionario<br>
 * Contiene los metodos que permiten gestionar el concesionario<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025<br><br>
 *
 * @author Borja Piñero
 */
public class Concesionario {

    private Vehiculo[] vehiculosAlmacenados;
    private int numVehiculo;

    /**
     * Crea el concesionario, un array que contendrá los vehiculos
     */
    public Concesionario() {
        this.vehiculosAlmacenados = new Vehiculo[50];
        this.numVehiculo = 0;

    }
    
    /**
     * Metodo que devuelve el numero de vehiculos que hay en el concesonario
     * @return Devuelve el numero de vehiculos que contiene el concesionario
     */
    public int getNumVehiculos() {
        return numVehiculo;
    }
    
    /**
     * Metodo que devuelve la posicion de un vehiculo en el array del concesionario
     * 
     * @param matricula La matricula de la que deseamos conocer la posición en el 
     * array
     * @return Devuelve la posicion del vehiculo en el concesionario, o -1 si no 
     * se encuentra en él.
     */
    public int obtenerPosicionVehiculo(String matricula){
        
        for (int i = 0; i < numVehiculo; i++){
            if (vehiculosAlmacenados[i].getMatricula().equals(matricula)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Metodo que inserta un vehiculo en el concesionario, siempre que el 
     * concesionario no este lleno ni la matricula ya exista en el concesionario - 
     * {@link Validaciones#matriculaEsUnica(com.damel.modelos.Vehiculo, com.damel.modelos.Concesionario) }
     * 
     * @param nuevoVehiculo Los datos del vehiculo
     * @return devuelve {@code -1} si el concesionario esta lleno<br>
     * devuelve {@code  -2} si la matricula ya existe en el concesionario<br>
     * devuelve {@code 0} si el vehiculo se añade corretamente
     */
    public int insertarVehiculo(Vehiculo nuevoVehiculo) {
        
        if (numVehiculo >= vehiculosAlmacenados.length) {
            return -1;
        }
        
        if (!Validaciones.matriculaEsUnica(nuevoVehiculo, this)) {
            return -2;
        }
        
        vehiculosAlmacenados[numVehiculo] = nuevoVehiculo;
        numVehiculo++;
        return 0;
    }

    /**
     * Método que busca un vehiculo en el concesionario, a partir de la matricula
     * 
     * @param matricula La matricula a buscar
     * @return Devuelve {@code null} si el vehiculo no existe en el concesionario
     * y una {@code String} con los datos del vehículo en caso de que exista.
     */
    public String buscaVehiculo(String matricula) {
        
        int posicion = obtenerPosicionVehiculo(matricula);
        
        if (posicion != -1) {
            return vehiculosAlmacenados[posicion].toString();
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

        for (int k = 0; k < numVehiculo; k++) {
            lista.append("Vehiculo ")
                    .append(k + 1)
                    .append("\n")
                    .append(vehiculosAlmacenados[k].toString())
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
        
        int posicion = obtenerPosicionVehiculo(matricula);
        
        if (posicion !=-1) {
            vehiculosAlmacenados[posicion].setKm(nuevoKm);
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
        int posicion = obtenerPosicionVehiculo(matricula);
        
        if (posicion == -1) {
            return "Error: El vehiculo con matricula " +matricula +" no existe.";
        }
        
        for (int i = posicion; i < numVehiculo - 1; i++) {
            vehiculosAlmacenados[i] = vehiculosAlmacenados[i+1];
        }
        
        vehiculosAlmacenados[numVehiculo - 1] = null;
        numVehiculo--;
        
        return "El vehiculo con matricula " +matricula +" se ha eliminado correctamente";
        
    }
}