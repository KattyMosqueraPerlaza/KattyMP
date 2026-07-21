/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        System.out.print("Ingrese su edad: ");
        edad = sc.nextInt();
        if(edad >= 18){
            System.out.print("Es mayor de edad");
        }
    } 
}
