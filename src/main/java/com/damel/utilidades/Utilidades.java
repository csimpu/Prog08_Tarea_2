/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.utilidades;

import java.util.Scanner;

/**
 * Clase Uildades<br>
 * Contiene métodos que realizan acciones no relacionadas con la lógica del programa<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Utilidades {

    /**
     * Pausa la ejecución del programa hasta que el usuario presiones la tecla
     * ENTER, permitiendo una mejor lectura de los elementos de cada submenú
     *
     */
    public static void enterParaSalir() {

        Scanner entrada = new Scanner(System.in);

        System.out.println();

        System.out.print("Presiona ENTER para continuar...");
        System.out.println();

        entrada.nextLine();

    }

    /**
     * Algoritmo que obtiene la letra de DNI que le corresponde a un numero de DNI
     * 
     * @param dni El DNI del que se va a calcular la letra
     * @return devuelve la letra correspondiente a esa numeracion
     */
    public static String calcularLetraDni(String dni) {
        String[] letraDni = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",
            "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        String dniSinLetra = dni.substring(0, 8);

        int numDni = Integer.parseInt(dniSinLetra);

        int posicionTabla = numDni % 23;

        return letraDni[posicionTabla];

    }

}
