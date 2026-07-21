/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador;
        int num;
        contador = 0;
        System.out.print("Ingrese un numero: ");
        num = sc.nextInt();
        if (num>=0){
            contador++;
        }
        while (num>=0){
            System.out.print("Ingrese un numero: ");
            num = sc.nextInt();
            if (num>=0){
                contador++;
            }
        } 
        System.out.println("Los Numeros positivos fueron:" +contador);
    }
    
}
