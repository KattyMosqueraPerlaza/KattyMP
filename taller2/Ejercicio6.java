/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio6 {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       int[][] matriz = new int[3][4];
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Ingrese valor: ");
                matriz[i][j] = sc.nextInt(); 
            }
       }
       System.out.println();
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] +" ");
        }
            System.out.println();
        }
    }   
}
