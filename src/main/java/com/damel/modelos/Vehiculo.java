/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.modelos;

/**
 * Clase Vehiculo<br>
 * Contiene los metodos para crear el objeto vehiculo e interactuar con sus
 * atributos.<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025<br><br>
 *
 * @author Borja Piñero
 */
public class Vehiculo implements Comparable<Vehiculo>{ // Implemento la intefaz

    private String matricula,
            marca,
            descripcion,
            nombrePropietario,
            dni;
    private double precio,
            km;
    
    /**
     * Constructor del objeto Vehiculo.<br> 
     * Crea un nuevo vehículo con los datos proporcionados en los parámetros
     * 
     * @param matricula Debe ser única y cumplir con el formato de las matriculas
     * de españa, es decir, 0000BBB, no pudiendo tener vocales, ni Ñ ni Q.
     * @param marca La marca del vehículo
     * @param descripcion Una breve descripción del vehiculo
     * @param nombrePropietario Nombre del propietario, con formato Nombre Apellido1
     * Apellido2
     * @param dni El DNI del propietario, con la letra correspondiente a esos números
     * de acuerdo al algoritmo de calculo de letra de los DNI españoles
     * @param precio El precio del vehiculo, debe ser un numero positivo
     * @param km Los kilometros que tiene el vehiculo, debe ser un numero positivo
     */
    public Vehiculo(String matricula, String marca, String descripcion,
            String nombrePropietario, String dni, double precio, double km) {
        this.matricula = matricula;
        this.marca = marca;
        this.descripcion = descripcion;
        this.nombrePropietario = nombrePropietario;
        this.dni = dni;
        this.precio = precio;
        this.km = km;

    }
    
    /**
     * Getter para matricula
     * @return Devuelve la matricula
     */
    public String getMatricula() {
        return matricula;
    }
    
    /**
     * Setter para matricula
     * @param matricula establece el valor de la matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    /**
     * Getter para marca
     * @return Devuelve la marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter para marca
     * @param marca establece la marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter para la descripcion del vehiculo
     * @return Devuelve la descripcion del vehiculo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter para la descripcion del vehiculo
     * @param descripcion establece la descripcion del vehiculo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter para Nombre del propietario
     * @return Devuelce el nombre del propietario
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * Setter para Nombre del Propietario
     * @param nombrePropietario establece el nombre del propietario
     */
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    /**
     * Getter para DNI
     * @return Devuelve el DNI del propietario
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter para DNI
     * @param dni establece el DNI del propietario
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Getter para precio del vehiculo
     * @return Devuelve el precio del vehiculo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter para precio del vehiculo
     * @param precio Establece el precio del vehiculo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Getter para kilometros del vehiculo
     * @return Devuelve los kilometros del vehiculo
     */
    public double getKm() {
        return km;
    }

    /**
     * Setter para kimoletros del vehiculo
     * @param km Establece los kilometros del vehiculo
     */
    public void setKm(double km) {
        this.km = km;
    }

    /**
     * Metodo toString que devuelve los datos del vehiculo
     * @return Devuelve una lista con los datos del vehiculo
     */
    @Override
    public String toString() {
        return "Matricula: " + matricula 
                + "\nMarca: " + marca 
                + "\nDescripcion: " + descripcion 
                + "\nNombre del propietario:\n" + nombrePropietario 
                + "\nDNI: " + dni 
                + "\nPrecio: " + precio 
                + "\nKilometros: " + km;
    }
    
    /**
     * Metodo que com
     * @param otroVehiculo
     * @return 
     */
    @Override
    public int compareTo(Vehiculo otroVehiculo){
        return this.matricula.compareTo(otroVehiculo.matricula);
    }

}
