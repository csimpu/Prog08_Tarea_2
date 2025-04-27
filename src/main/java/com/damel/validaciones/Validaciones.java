/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.damel.validaciones;

import com.damel.modelos.*;
import com.damel.utilidades.Utilidades;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Validaciones<br>
 * 
 * Contiene los metodos que validan los datos que se introducen<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025<br><br>
 *
 * @author Borja Piñero
 */
public class Validaciones {
    
    /**
     * Metodo que valida que la matricula es unica
     * 
     * @param nuevoVehiculo El vehiculo del que se valida la matricula
     * @param concesionario El concesionario al que pertenece
     * @return Devuelve {@code true} si la matricula no esta en el concesionario
     */
    public static boolean matriculaEsUnica (Vehiculo nuevoVehiculo, Concesionario concesionario) {
        return concesionario.buscarMatricula(nuevoVehiculo.getMatricula()) == null;
    }

    /**
     * Metodo que valida que el formato de la matricula es el adecuado, es decir,
     * cuatro numeros seguido de tres letras mayúsculas, que no sean vocales, 
     * Ñ o Q.<br><br>
     * <i>Formato: NNNNLLL</i>
     * 
     * @param matricula la matricula a validar
     * @return Devuelve {@code true} si la matricula tiene el formato correcto
     */
    public  static boolean formatoMatricula(String matricula){
        String regEx = "^\\d{4}[B-DF-HJ-NPR-TW-Z]{3}$";

        
        Pattern patron = Pattern.compile(regEx);
        Matcher coincide = patron.matcher(matricula);
        return coincide.matches();
    }
    
    /**
     * Metodo que valida que el nombre del propietario tenga un formato correcto,
     * es decir,<br><br>
     * 
     * <i>Nombre Apellido1 Apellido2</i>
     * 
     * @param propietario el mobre a validar
     * @return devuelve {@code true} si el formato es correcto y {@code false} si
     * el nombre tiene mas de 40 caracteres o no cumple con el formato adecuado.
     */
    public static boolean nombreEsValido (String propietario){
        String regEx = "^[A-ZÑ][a-zñ]+\\s[A-ZÑ][a-zñ]+\\s[A-ZÑ][a-zñ]+$";
        
        if (propietario.length() > 40){
            return false;
        }
        
        Pattern patron = Pattern.compile(regEx);
        Matcher coincide = patron.matcher(propietario);
        return coincide.matches();
    }
    
    /**
     * Metodo que valida que el DNI tiene 8 digitos y una letra y esta cumple con 
     * las reglas de asignación de letra.<br>
     * Comprueba que la letra asignada es la que corresponde a la numeración, de
     * acuerdo con el algoritmo de calculo de letra de DNI.<br><br>
     * 
     * {@link Utilidades#calcularLetraDni(String dni)}
     * 
     * @param dni el DNI a validar
     * @return devuelve {@code true} si la letra es correcta y el DNI tiene 8 digitos
     */
    public static boolean dniEsValido (String dni){
        
        String regEx = "^[0-9]{8}[A-Z]{1}$";
        
        Pattern patron = Pattern.compile(regEx);
        Matcher coincide = patron.matcher(dni);

        if (coincide.matches()){
            
            String dniSinNumero = dni.substring(8);
            boolean letraCorrecta = dniSinNumero.equals(Utilidades.calcularLetraDni(dni));
            return letraCorrecta;
            
        } return false; 
        
    }
    
    /**
     * Metodo que valida que el precio es positivo
     * 
     * @param precio El precio introducido
     * @return Devuelve {@code true} si el precio es mayor que 0
     */
    public static boolean precioEsPositivo (double precio){
        return precio > 0;
    }
    
    /**
     * Metodo que valida que los kilometros son positivos
     * 
     * @param km Los kilometros introducidos
     * @return Devuelve {@code true} si los kilometros son mayor que 0
     */
    public static boolean kmEsPositivo (double km){
        return km > 0;
    }

}
