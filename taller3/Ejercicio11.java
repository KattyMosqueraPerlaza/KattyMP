package com.mycompany.taller3;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
public class Ejercicio11 {
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
    public static void main(String[] args) {
        int num = 7;
        if (esPar(num)) {
            System.out.println(num + " es par.");
        } else {
            System.out.println(num + " es impar.");
        }
    }
}