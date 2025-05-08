package Java.AEA4.InvertirParaules;

import java.io.*;

public class main {
    public static void main(String[] args) {
        File path = null;
        try{
            path = new File(main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            
            System.out.println("Path: " + path.getParent());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        String abspath = path.getParent().replace(".", "");

        String InputFilePath = abspath + "input.txt";
        String OutputFilePath = abspath + "output.txt";
        
        BufferedReader lector = null;
        FileWriter writer = null;
        
        try {
            lector = new BufferedReader(new FileReader(InputFilePath));
            writer = new FileWriter(OutputFilePath);

            String linia;
            
            // Llegim cada línia del fitxer d'entrada
            while ((linia = lector.readLine()) != null) {
                char[] arrayLinea = linia.toCharArray();
                for(int i = 0; i<arrayLinea.length;i++){
                    writer.write(arrayLinea[arrayLinea.length-1-i]);
                }
                writer.write(System.lineSeparator());
            }
            
            System.out.println("Fitxer processat correctament. Resultat guardat a " + OutputFilePath);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try{
                lector.close();
                writer.close();
            }
            catch(IOException e){
                System.out.println("No s'ha pogut tancar correctament");
            } 
        }
    }
}