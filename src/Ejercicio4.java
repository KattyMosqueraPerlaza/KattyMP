/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double nota;
    System.out.print("Ingrese su nota: ");
    nota = sc.nextDouble();
    if (nota>=7){
        System.out.print("Aprobado");
    }else{
        System.out.print("Reprobado");
    }
  }   
}
