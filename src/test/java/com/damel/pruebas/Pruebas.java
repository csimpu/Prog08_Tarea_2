/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.damel.pruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.damel.modelos.*;
import com.damel.validaciones.*;

/**
 *
 * @author borja
 */
public class Pruebas {
    
    @Test
    void testFormatoMatricula() {
        assertTrue(Validaciones.formatoMatricula("1234BCD"),
                "La matricula debe tener 4 numeros y 3 letras");
        assertFalse(Validaciones.formatoMatricula("123BCD"), 
                "La matricula tiene 3 numeros");
        assertFalse(Validaciones.formatoMatricula("1234BCÑ"), 
                "La matricula tiene letras no validas");
    }

    @Test
    void testNombreEsValido() {
        assertTrue(Validaciones.nombreEsValido("Juan Perez Lopez"),
                "El nombre deberia ser Nombre Apellido Apellido");
        assertTrue(Validaciones.nombreEsValido("Meño Piñero Piña"),
                "El nombre debe poder contener ñ");        
        assertFalse(Validaciones.nombreEsValido("JuanPerez"),
                "El nombre deberia ser Nombre Apellido Apellido");
        assertFalse(Validaciones.nombreEsValido("J P L"),
                "El nombre no pueden ser iniciales");
        assertFalse(Validaciones.nombreEsValido(
                "Este Nombre Laaaaaaaaaaaaaaaaaaaaaaaaaaaaargo"),
                "El nombre tiene demasiados caracteres");
    }

    @Test
    void testDniEsValido() {
        assertTrue(Validaciones.dniEsValido("12345678Z"),
                "El DNI deberia tener 8 numeros y la letra correcta");
        assertFalse(Validaciones.dniEsValido("1234567Z"), 
                "El DNI no tiene 8 numeros");
        assertFalse(Validaciones.dniEsValido("12345678A"), 
                "El DNI tiene una letra incorrecta");
        assertFalse(Validaciones.dniEsValido("12345678"), 
                "El DNI no tiene letra");
    }

    @Test
    void testConcesionario() {
        Concesionario concesionario = new Concesionario();
        Vehiculo vehiculo1 = new Vehiculo("1234BCD", "Toyota", "Descripcion",
                "Juan Perez Lopez", "12345678Z", 20000, 15000);
        
         assertEquals(0,concesionario.insertarVehiculo(vehiculo1),
                 "0: Vehiculo anadido");
                
        Vehiculo vehiculo2 = new Vehiculo("1234BCD", "Honda", "Otra Descripcion",
                "Maria Garcia Gomez", "87654321X", 25000, 10000);
         
        assertEquals(-2, concesionario.insertarVehiculo(vehiculo2),
                "-2: Matricula duplicada");
        
        for (int i = 0; i < 50; i++) {
        concesionario.insertarVehiculo(new Vehiculo("000" + i + "BBB", "Ford", "Otro", "Carlos Ruiz Lopez", "11111111H", 18000, 5000));
    }
    Vehiculo vehiculo51 = new Vehiculo("5678EFG", "BMW", "Lujo", "Luis Fernandez", "22222222J", 50000, 20000);
    assertEquals(-1, concesionario.insertarVehiculo(vehiculo51), "-1: concesionario lleno.");
    }
    
        @Test
    void testBuscaVehiculo() {
        Concesionario concesionario = new Concesionario();
        Vehiculo vehiculo1 = new Vehiculo("1234BCD", "Toyota", "Descripcion",
                "Juan Perez Lopez", "12345678Z", 20000, 15000);
        
         assertEquals(0,concesionario.insertarVehiculo(vehiculo1));
        
        String matricula1 = vehiculo1.getMatricula();
        String matricula2 = "2345BBB";
                
        String resultado1 = concesionario.buscaVehiculo(matricula1);
        String resultado2 = concesionario.buscaVehiculo(matricula2);
        
        // Verificamos que el resultado sea null
        assertNotNull(resultado1);
        assertNull(resultado2);
    
    }
    
    @Test
void testModificarKm() {
    // 1. Configuración inicial
    Concesionario concesionario = new Concesionario();
    Vehiculo vehiculo = new Vehiculo("1234BCD", "Toyota", "Descripción", 
                                    "Juan Perez Lopez", "12345678Z", 20000, 15000);
    concesionario.insertarVehiculo(vehiculo); // Añadimos un vehículo de prueba
    
    // 2. Caso de éxito: modificar KM de un vehículo existente
    double nuevosKm = 20000;
    assertEquals(0, concesionario.modificarKm("1234BCD", nuevosKm), 
                "Debería retornar 0 si la matrícula existe");
    
    // Verificamos que los KM se actualizaron correctamente
    assertEquals(nuevosKm, vehiculo.getKm(), 
                "Los kilómetros del vehículo deberían haberse actualizado");
    
    // 3. Caso de error: matrícula inexistente
    assertEquals(-1, concesionario.modificarKm("9999ZZZ", 10000), 
                "Debería retornar -1 si la matrícula no existe");
}

    @Test
    void testEliminarVehiculo() {
        // Crear concesionario y añadir un vehículo
        Concesionario concesionario = new Concesionario();
        Vehiculo vehiculo = new Vehiculo("1234BCD", "Toyota", "Coche compacto", "Juan Perez Lopez", "12345678Z", 15000, 10000);
        
        concesionario.insertarVehiculo(vehiculo);

        // Verificar que el vehículo está dentro
        assertEquals(0, concesionario.obtenerPosicionVehiculo("1234BCD"));

        // Eliminar el vehículo
        String mensaje = concesionario.eliminarVehiculo("1234BCD");
        
        // Comprobar el mensaje de éxito
        assertEquals("El vehiculo con matricula 1234BCD se ha eliminado correctamente", mensaje);

        // Verificar que ya no existe
        assertEquals(-1, concesionario.obtenerPosicionVehiculo("1234BCD"));

        // Intentar eliminarlo de nuevo y verificar el mensaje de error
        String mensajeError = concesionario.eliminarVehiculo("1234BCD");
        assertEquals("Error: El vehiculo con matricula 1234BCD no existe.", mensajeError);
    }
}



