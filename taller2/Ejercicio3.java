/**
 *
 * @author Katty Gislayne Mosquera Perlaza
 */
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
     int[]num = new int[15];
     int mayor;
     int menor;
     int posicionMayor=0;
     int posicionMenor=0;
     for(int i=0; i<num.length; i++ ){
       System.out.print("Ingrese numero "+i+ ": ");
       num[i]=sc.nextInt();
     }
     mayor=num[0];
     menor=num[0];
     for(int i=0; i<num.length; i++){
         if(num[i]>mayor){
             mayor=num[i];
             posicionMayor=i;
         }
         if(num[i]<menor){
             menor=num[i];
             posicionMenor=i;
         }
     }
      System.out.println("El numero mayor fue: "+ mayor + " En la posicion: " + posicionMayor);
      System.out.println("El numero menor fue: "+ menor + " En la posicion: " + posicionMenor);
    }
}
