/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[][] matriz = new int[5][5]; 
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Ingrese valor para [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
                sc.nextLine();
            }
        }
        int mayor = matriz[0][0];
        int menor = matriz[0][0];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
            }
        }
        System.out.println("Mayor valor: " + mayor);
        System.out.println("Menor valor: " + menor);
    }
    
}
