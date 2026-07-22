package com.mycompany.taller3;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
public class Ejercicio6 {
    public static int obtenerNumero() {
        return (int)(Math.random() * 100) + 1;
    }
    public static void main(String[] args) {
        int numero = obtenerNumero();
        System.out.println("Numero aleatorio: " + numero);
    }
}