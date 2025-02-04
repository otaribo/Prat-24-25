package Java.UF1.AEA3.Llegir_enter_teclat;
import java.util.Scanner;
public class Llegir_enter_teclat {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = LLegirEnterTeclat(scan);
        System.out.println("L'enter introduit ha sigut " + a + ".");
        a = LLegirEnterTeclat(scan);
        System.out.println("L'enter introduit ha sigut " + a + ".");
    }
    public static int LLegirEnterTeclat(Scanner scan){
        boolean correcte=false;
        int Llegit = -45;
        while (!correcte) {
            scan.next();
            correcte = scan.hasNextInt();
            if (correcte) {
                Llegit = scan.nextInt();
            } 
            else {
                System.out.println("No es un enter.");
                scan.nextDouble();
            }
        }   
        scan.nextLine();
        return Llegit;
    }
}
