/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio11 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int num;
        int mayor;
        int menor;
        System.out.print("Ingrese un numero: ");
        num =sc.nextInt();
        mayor=num;
        menor=num;
        for(int i=1; i<=9; i++){
            System.out.print("Ingrese un numero: ");
            num = sc.nextInt();
            if (num>mayor){
                mayor=num;
            }else{
                if (num<menor){
                    menor=num;
                }
            }
        }
        System.out.println("El numero mayor fue: "+mayor);
        System.out.println("El numero menor fue: "+menor);
    }
}
