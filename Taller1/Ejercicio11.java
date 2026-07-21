package com.mycompany.Taller1;
/**
 *
 *@author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio11 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int num;
        int mayor;
        int menor;
        System.out.print("Ingrese un numero 1: ");
        num =sc.nextInt();
        mayor=num;
        menor=num;
        for(int i=2; i<=10; i++){
            System.out.print("Ingrese un numero "+ i +": ");
            num = sc.nextInt();
            if (num>mayor){
                mayor=num;
            }
            if (num<menor){
                    menor=num;
                }
            
        }
        System.out.println("El numero mayor fue: "+mayor);
        System.out.println("El numero menor fue: "+menor);
    }
}
