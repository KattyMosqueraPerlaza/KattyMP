package com.mycompany.Taller1;
/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio2 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      int num1;
      int num2;
      int suma;
      int resta;
      int multiplicacion;
      double division;
      double residuo;
      System.out.print("Ingrese numero 1: ");
      num1 = sc.nextInt();
      sc.nextLine();
      System.out.print("Ingrese numero 2: ");
      num2 = sc.nextInt();
        
      System.out.println();
      System.out.println("La suma de los numeros es: " + (num1+num2));
      System.out.println("La resta de los numeros es: " + (num1-num2));
      System.out.println("La multiplicacion de los numeros es: " + (num1*num2));
      System.out.println("La division de los numeros es: " + (num1/num2));
      System.out.println("El residuo de los numeros es: " + (num1%num2));
    } 
}
    
