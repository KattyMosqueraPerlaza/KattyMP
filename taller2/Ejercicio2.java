/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double[] num = new double[10];
        double suma=0;
        double promedio;
        for(int i=0; i<num.length; i++){
            System.out.print("Ingrese numero "+i+ ": ");
            num[i]=sc.nextDouble();
            suma=num[i]+suma;
            
        }
        promedio=suma/num.length;
        System.out.println("La suma de los numeros fue: "+suma);
         System.out.println("El promedio de los numeros fue: "+promedio);
    }
}
