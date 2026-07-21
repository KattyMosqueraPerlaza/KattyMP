/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String clave;
        do {
            System.out.print("Ingrese la clave: ");
            clave = sc.nextLine();            
        }while (!clave.equals("java2026"));
        System.out.print("Acceso concedido");
    }   
}
