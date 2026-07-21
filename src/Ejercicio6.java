/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class Ejercicio6 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion;
    System.out.print("Ingrese un numero del 1 al 7: ");
    opcion =sc.nextInt();
    switch(opcion){
        case 1:
            System.out.print("Lunes");
            break;
        case 2:
            System.out.print("Martes");
            break;
        case 3:
            System.out.print("Miercoles");
            break;
        case 4:
            System.out.print("Jueves");
            break;
        case 5:
            System.out.print("Viernes");
            break;
        case 6:
            System.out.print("Sabado");
            break;
        case 7:
            System.out.print("Domingo");
            break;
        default: 
            System.out.print("Opcion no valida");
    } 
    }
    
}
