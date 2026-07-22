package com.mycompany.taller3;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
public class Ejercicio9 {
    public static double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }
    public static void main(String[] args) {
        double promedio = calcularPromedio(8, 7, 9);
        System.out.println("Promedio: " + promedio);
        if (promedio >= 7) {
            System.out.println("Estudiante aprobado.");
        } else {
            System.out.println("Estudiante reprobado.");
        }
    }
}

