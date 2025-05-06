package Java.AEA4.ContadorParaules;

import java.io.*;

public class main {
    public static void main(String[] args) {
        //ruta dels txt
        String InputFilePath = "C:\\Github\\Prat-24-25\\Java\\AEA4\\ContadorParaules\\input.txt";
        String OutputFilePath = "C:\\Github\\Prat-24-25\\Java\\AEA4\\ContadorParaules\\output.txt";
        
        int comptadorParaules = 0;
        BufferedReader lector = null;
        FileWriter writer = null;
        
        try {
            // Comprobem si l'arxiu existeix
            File InputFile = new File(InputFilePath);
            if (!InputFile.exists()) {
                System.out.println("L'arxiu " + InputFilePath + " no s'ha trobat.");
                return;
            }
            
            // Llegim el arxiu d'entrada i contem les paraules que té
            lector = new BufferedReader(new FileReader(InputFilePath));
            String linia;
            
            while ((linia = lector.readLine()) != null) {
                // Dividim la linea en paraules en base de els espais en blancs que trobe
                String[] paraules = linia.split("\\s+");
                comptadorParaules += paraules.length;
            }
            
            // Escribim el numero de paraules al arxiu 
            writer = new FileWriter(OutputFilePath, false);
            writer.write("Nombre total de paraules: " + comptadorParaules);
            
            System.out.println("El arxiu té " + comptadorParaules + " paraules.");
            
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