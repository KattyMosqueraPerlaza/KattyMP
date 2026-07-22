/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nume= new int[12];
        int num;
        for(int i=0; i<nume.length; i++){
           System.out.print("Ingrese un numero " + i + ": ");
           num=sc.nextInt();
           nume[i]=num+i;
       }
        System.out.println("==============================");
        for (int i = 0; i < nume.length; i++) {
            System.out.println("Resultado " + i + ": " + nume[i]);
        }
    }
    
}
