/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for(int i=0; i<num.length; i++){
            System.out.print("Ingrese numero " + i + ": ");
            num[i]=sc.nextInt();
        } 
        System.out.println("Valores");
        for (int i = 0; i < num.length; i++) {
            System.out.println("Posicion " + i + ": " + num[i]);
        }
    }
}
