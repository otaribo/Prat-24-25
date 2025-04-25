package Java.AEA4.LLegirNotes;

import java.io.File;
import java.util.Scanner;


public class LlegirNotes {
    public static final String MARCA_FI = "fi";
    public static void main (String[] args) {

        try {
            File f = new File("C:\\Github\\Prat-24-25\\Java\\AEA3\\LLegirNotes\\notes");                
            Scanner lector = new Scanner(f);
            boolean llegir = true;
            while (llegir) {
                String nom = lector.next();
                if (MARCA_FI.equals(nom)) {
                    llegir = false;
                }
                else {
                    String cognom = lector.next();
                    System.out.print("Estudiant: " + nom + " " + cognom);
                    double mitjana = llegirNotes(lector);
                    System.out.println(" − Mitjana: " + mitjana);
                }
            }
            lector.close();
            }
            
        catch(Exception e) {
            System.out.println("1 Error llegint estudiants: " + e);
        }
    }

    public static double llegirNotes(Scanner lector) {
        double res = 0;
        try {
            int numNotes = lector.nextInt();
            for (int i = 0; i < numNotes; i++) {
                res = res + lector.nextDouble();
            }
            res = res/numNotes;
        }
        catch (Exception e) {
            System.out.println("2 Error llegint notes: " + e);
        }
        return res;
    }
}