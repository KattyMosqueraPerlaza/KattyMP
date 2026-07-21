/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio9 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num;
      System.out.print("Ingrese un numero: ");
      num = sc.nextInt();
      
      for(int i=1; i<=12; i++){
          System.out.println(num + "x" + i + "=" +(num*i));         
      }
    }
}
