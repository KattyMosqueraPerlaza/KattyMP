/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio5 {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    double nota;
    System.out.print("Ingrese su nota: ");
    nota = sc.nextDouble();
    if (nota>=10 && nota<=9){
        System.out.print("Excelente");
    }else{
        if (nota>=8 && nota<=8.99){
            System.out.print("Muy Bueno");    
        }else{
            if (nota>=7 && nota<=7.99){
                System.out.print("Bueno"); 
        }else{
                if (nota>=5 && nota<=6.99){
                System.out.print("Regular");
            }else{
                  if (nota>=0 && nota<=4.99){
                    System.out.print("Deficiente");  
                }
            }
        }   
    }       
    }
} 
}
