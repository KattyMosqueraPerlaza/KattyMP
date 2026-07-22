/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int suma = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Ingrese valor [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
                sc.nextLine();
                suma += matriz[i][j];
            }
        }
        System.out.println("=================================");
        System.out.println("La suma total es: " + suma);
    }
}
