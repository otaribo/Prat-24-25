package AEA3.Allotjament;

import java.util.Scanner;

public class lectorDatosTerminal {

    private Scanner s = new Scanner(System.in);
    
    public double leerDouble(){

        while (!s.hasNextDouble()) {
            System.out.println("Entrada no válida. Introduce un valor válido:");
            s.next(); 
        }
        return s.nextDouble();
    }

    public int leerInt(){
        while (!s.hasNextInt()) {
            System.out.println("Entrada no válida. Introduce un valor válido:");
            s.next(); 
        }
        return s.nextInt();
    }

    public String leerString() {
        while (!s.hasNext()) {
            System.out.println("Entrada no válida. Introduce un valor válido:");
            s.next(); 
        }
        return s.next();
    }


    

    

}
