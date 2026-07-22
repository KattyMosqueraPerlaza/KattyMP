/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int[] num= new int[20];
       int numPar=0;
       int numImpar=0;
       int sumPar=0;
       int sumaImpar=0;
       for(int i=0; i<num.length; i++){
           System.out.print("Ingrese un numero " + i + ": ");
           num[i]=sc.nextInt();
       }
       for(int i=0; i<num.length; i++){
           if(num[i] % 2 == 0){
               numPar++;
               sumPar+= num[i];              
           }else{
               numImpar++;
               sumaImpar+= num[i];              
           }
       }
        System.out.println("Cantidad de numeros pares: " + numPar);
        System.out.println("Cantidad de numeros impares: " + numImpar);
        System.out.println("Suma de los pares: " + sumPar);
        System.out.println("Suma de los impares: " + sumaImpar);
    }    
}
