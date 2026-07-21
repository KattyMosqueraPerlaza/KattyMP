/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio10{
    public static void main(String[] arg){
      Scanner sc=new Scanner(System.in);
      int num;
      int suma;
      suma=0;
      for(int i=1; i<=10; i++){
          System.out.print("Ingrese un numero "+i+ ":");
          num =sc.nextInt();
          suma=num+suma;
      }
      System.out.println("La suma de los numeros fue: "+suma);
      System.out.println("El promedio de los numeros fue: "+(suma/10));
    }
}
