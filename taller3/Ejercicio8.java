package com.mycompany.taller3;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
public class Ejercicio8 {
    public static double calcularArea(double base, double altura) {
        return base * altura;
    }
    public static void main(String[] args) {
        double area = calcularArea(5, 3);
        System.out.println("Area del rectangulo: " + area);
    }
}