package com.mycompany.Taller1;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nom;
        int edad;
        String carrera;
        double estatura;
        System.out.print("Ingrese su nombre: ");
        nom = sc.nextLine();
        System.out.print("Ingrese su edad: ");
        edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese su carrera: ");
        carrera = sc.nextLine();
        System.out.print("Ingrese su estatura: ");
        estatura = sc.nextDouble();
        System.out.println();
        System.out.println("DATOS REGISTRADOS");
        System.out.println("Nombre: " + nom);
        System.out.println("Edad: " + edad + " anios");
        System.out.println("Carrera: " + carrera);
        System.out.println("Estatura: " + estatura + "cm");
    }
}
