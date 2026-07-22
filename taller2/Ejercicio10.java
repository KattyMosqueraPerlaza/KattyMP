/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][5];
        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 5; j++) {      
                System.out.print("Ingrese valor para [" + i + "][" + j + "]: ");
                int valor = sc.nextInt();
                matriz[i][j] = valor + (i * j);
            }
        }
        System.out.println("===========================");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
