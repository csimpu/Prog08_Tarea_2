/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.damel.principal;

import com.damel.utilidades.Utilidades;
import com.damel.modelos.Vehiculo;
import com.damel.modelos.Concesionario;
import com.damel.validaciones.Validaciones;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase Principal<br>
 * Contiene el menu principal del programa. Permite añadir un vehiculo, listar
 * los vehiculos en el concesionario, buscar un vehiculo por matricula, editar los
 * kilometros de un vehiculo y eliminar un vehiculo.<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025<br><br>
 * 
 * @author borja
 */
public class Principal {

    /**
     * Metodo main de la clase Principal
     * @param args <i>No utilizado</i>
     */
    public static void main(String[] args) {

        String matricula,
                marca,
                descripcion,
                nombrePropietario,
                dni,
                buscaMatricula,
                vehiculoEncontrado;
        double precio,
                km,
                nuevosKm;
        int opcion;

        Concesionario concesionario = new Concesionario();

        Scanner entrada = new Scanner(System.in);

        do {

            System.out.println("*************************************");
            System.out.println("*      Gestor de concesionario      *");
            System.out.println("*************************************");
            System.out.println("[1] - Nuevo vehiculo");
            System.out.println("[2] - Listar vehiculo");
            System.out.println("[3] - Buscar vehiculo");
            System.out.println("[4] - Modificar km vehiculo");
            System.out.println("[5] - Eliminar vehiculo");
            System.out.println("[6] - Salir               [0] - Ayuda");
            System.out.println("*************************************");
            System.out.print("Introduce una opcion: ");
            
            try {
                opcion = entrada.nextInt();
                
            } catch (InputMismatchException eIMEm){
                System.err.println("Error: debes introducir un numero del 0 al 6");
                entrada.nextLine();
                opcion = 0;
                continue;
            }
            
            System.out.println("*************************************");
            System.out.println();
            entrada.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.println("*************************************");
                    System.out.println("*          Nuevo vehiculo           *");
                    System.out.println("*************************************");

                    do{
                        System.out.println("Introduce la matricula: ");
                    

                    matricula = entrada.nextLine();
                    
                    if (!Validaciones.formatoMatricula(matricula)){
                        System.out.println("Error: La matricula debe estar en mayusculas y no");
                        System.out.println("contener los siguientes caracteres:");
                        System.out.println("A, E, I, Ñ, O, Q, U");
                    }
                    } while (!Validaciones.formatoMatricula(matricula));

                    System.out.println("Introduce la marca: ");

                    marca = entrada.nextLine();

                    System.out.println("Introduce una descripcion: ");

                    descripcion = entrada.nextLine();
                    
                    do {
                    System.out.println("Introduce el nombre del propietario: ");
                    
                    nombrePropietario = entrada.nextLine();
                                        
                    if (!Validaciones.nombreEsValido(nombrePropietario)){
                        System.out.println("Error: El nombre del propietario debe ser:");
                        System.out.println("Nombre Apellido1 Apellido2");
                    }
                    } while (!Validaciones.nombreEsValido(nombrePropietario));
                    
                    do {
                    System.out.println("Introduce el DNI del propietario");

                    dni = entrada.nextLine();
                                       
                    if (!Validaciones.dniEsValido(dni)){
                        System.out.println("Error: El DNI debe tener el formato 12345678Z");
                        System.out.println("y la letra debe ser la correcta, de acuerdo al");
                        System.out.println("algoritmo del calculo de letra del DNI");
                    }
                    } while (!Validaciones.dniEsValido(dni));

                    do {
                    System.out.println("Introduce el precio del vehiculo");

                    try {
                        precio = entrada.nextDouble();
                    } catch (InputMismatchException eIMEp){
                        System.err.println("Error: el precio debe ser un numero");
                        entrada.nextLine();
                        precio = 0;
                        continue;
                    }
                    
                    
                    if (!Validaciones.precioEsPositivo(precio)){
                        System.out.println("Error: El precio debe ser positivo");
                    }
                    } while (!Validaciones.precioEsPositivo(precio));
                    
                    do{
                    System.out.println("Introduce los kilometros del ");
                    System.out.println("vehiculo");

                    try {
                        km = entrada.nextDouble();
                    } catch (InputMismatchException eIMEk){
                        System.err.println("Error: Los km deben ser numeros");
                        entrada.nextLine();
                        km = 0;
                        continue;
                    }
                    
                    if (!Validaciones.kmEsPositivo(km)){
                        System.out.println("Error: Los km deben ser positivos");
                    }
                    } while (!Validaciones.kmEsPositivo(km));
                                    
                    Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, 
                            descripcion, nombrePropietario, dni, precio, km);
                    
                    boolean vehiculoInsertado = concesionario.insertarVehiculo(nuevoVehiculo);
                    
                    if (vehiculoInsertado == false)
                        System.err.println("""
                                           Error -2: La matricula ya esta en
                                           el concesionario""");
                    
                    if (vehiculoInsertado == true)
                        System.out.println("Vehiculo anadido");
                    
                                        
                    System.out.println("*************************************");
                    
                    Utilidades.enterParaSalir();

                }

                case 2 -> {
                    System.out.println("*************************************");
                    System.out.println("*         Lista de vehiculos        *");
                    System.out.println("*************************************");
                    
                    System.out.println(concesionario.listaVehiculos());
                    
                    System.out.println("*************************************");
                    Utilidades.enterParaSalir();
                }

                case 3 -> {
                    System.out.println("*************************************");
                    System.out.println("*          Buscar vehiculo          *");
                    System.out.println("*************************************");
                    System.out.println("Introduce la matricula que quieres");
                    System.out.print("buscar: ");
                    
                    buscaMatricula = entrada.nextLine();
                    
                    vehiculoEncontrado = concesionario.buscarVehiculo(buscaMatricula);
                                       
                    if (vehiculoEncontrado == null)                        
                        System.out.println("No existe el vehiculo con matricula "
                        + buscaMatricula);
                    
                    else {                        
                        System.out.println("El vehiculo que buscas es:");
                        System.out.println(vehiculoEncontrado);
                        
                    }
                    
                    System.out.println("*************************************");
                    Utilidades.enterParaSalir();
                }

                case 4 -> {
                    System.out.println("*************************************");
                    System.out.println("*           Modificar km            *");
                    System.out.println("*************************************");
                    System.out.println("Introduce la matricula del coche que");
                    System.out.print("quieres modificar los km: ");
                                                
                    buscaMatricula = entrada.nextLine();
                    
                    do {
                    System.out.print("Introduce los nuevos km: ");
                    
                    nuevosKm = entrada.nextDouble();
                    
                    if (!Validaciones.kmEsPositivo(nuevosKm)){
                        System.out.println("Error: no puedes restar kilometros");                 
                    }
                    
                    } while (!Validaciones.kmEsPositivo(nuevosKm));
                    
                    int kmModificados = concesionario.modificarKm(buscaMatricula, nuevosKm);
                    
                    if (kmModificados == 0)
                        System.out.println("Kilometros actualizados");
                    
                    if (kmModificados ==-1)
                        System.out.println("No existe el vehiculo");                        

                    System.out.println("*************************************");
                    Utilidades.enterParaSalir();

                }

                case 5 -> {
                    System.out.println("*************************************");
                    System.out.println("*         Eliminar vehiculo         *");
                    System.out.println("*************************************");
                    System.out.println("Introduce la matricula del coche que");
                    System.out.print("quieres eliminar: ");
                    
                    buscaMatricula = entrada.nextLine();
                    
                    String vehiculoEliminado = concesionario.eliminarVehiculo(buscaMatricula);
                    
                    System.out.println(vehiculoEliminado);
                    
                    
                    System.out.println("*************************************");
                    Utilidades.enterParaSalir();                    
                }

                case 6 -> {
                    System.out.println("Cerrando inventario. Hasta pronto");

                }

                case 0 -> {
                    System.out.println("*************************************");
                    System.out.println("*               Ayuda               *");
                    System.out.println("*************************************");
                    System.out.println("[1] - Anade un nuevo vehiculo");
                    System.out.println("[2] - Lista los vehiculos del");
                    System.out.println("      concesionario");
                    System.out.println("[3] - Busca un vehiculo por");
                    System.out.println("      matricula");
                    System.out.println("[4] - Modifica los km de un");
                    System.out.println("      vehiculo");
                    System.out.println("[5] - Elimina un vehiculo del");
                    System.out.println("      concesionario");
                    System.out.println("*************************************");

                    Utilidades.enterParaSalir();
                }
            }

        } while (opcion != 6);

    }

}
