package Java.AEA4.InvertirParaules;

import java.io.*;

public class main {
    public static void Main(String[] args) {
        String InputFilePath = "C:\\Github\\Prat-24-25\\Java\\AEA4\\InvertirParaules\\input.txt";
        String OutputFilePath = "C:\\Github\\Prat-24-25\\Java\\AEA4\\InvertirParaules\\output.txt";
        
        String reverse = "";
        BufferedReader lector = null;
        FileWriter writer = null;
        
        try {
            File InputFile = new File(InputFilePath);
            if (!InputFile.exists()) {
                System.out.println("L'arxiu " + InputFilePath + " no s'ha trobat.");
                return;
            }
        
            lector = new BufferedReader(new FileReader(InputFilePath));
            String caracter;
            
            while ((caracter = lector.readLine()) != null) {
                for (char i:caracter.toCharArray()) {
                    reverse = i + reverse;
                }
            }
            
            writer = new FileWriter(OutputFilePath, false);
            writer.write("Text Final: " + reverse);
            
            System.out.println("Resultat:\n" + reverse);
            
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