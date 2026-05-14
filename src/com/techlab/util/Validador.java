package com.techlab.util;

import com.techlab.excepciones.StockInsuficienteException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {

    public static void validarNombre(String nombre) {
       
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecio(double precio) {
        
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpia el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println(" Debe ingresar un número entero. Intente nuevamente.");
                sc.nextLine(); // descarta lo que el usuario escribió mal
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número (puede usar coma o punto). Intente nuevamente.");
                sc.nextLine(); // lee un String completo hasta el Enter y lo devuelve.
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        // Lectura simple de texto. La validación de "no vacío" la
        // hacen los métodos validarNombre / validarCategoria
        // (cada función con una sola responsabilidad).
        System.out.print(mensaje);
        return sc.nextLine(); // lee un String completo hasta el Enter y lo devuelve.
    }
}
