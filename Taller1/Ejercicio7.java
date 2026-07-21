package com.mycompany.Taller1;
/**
 *
 *@author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador;
        int num;
        int suma=0;
        contador = 0;
        System.out.print("Ingrese un numero: ");
        num = sc.nextInt();
        if (num>=0){
            contador++;
            suma=suma+num;
        }
        while (num>=0){
            System.out.print("Ingrese un numero: ");
            num = sc.nextInt();
            if (num>=0){
                contador++;
                suma=suma+num;
            }
        } 
        System.out.println("Los Numeros positivos fueron:" +contador);
        System.out.println("La suma de los numeros positivos fue:" +suma);
    }   
}
