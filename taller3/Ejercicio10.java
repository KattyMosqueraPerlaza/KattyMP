package com.mycompany.taller3;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
public class Ejercicio10 {
    public static int mayor(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static void main(String[] args) {
        int resultado = mayor(15, 20);
        System.out.println("El mayor es: " + resultado);
    }
}