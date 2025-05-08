package Java.AEA4.InvertirParaules;

import java.io.*;

public class main {
    public static void main(String[] args) {
        File path = null;
        //trobem la path base del fitxer (Sol la troba si el document s'executa desde terminal!!!!)
        try{
            path = new File(main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        }
        catch (Exception e) {}

        String abspath = path.getParent().replace(".", "");

        //Especifiquem la path dels arxius d'entrada i sortida.
        String InputFilePath = abspath + "input.txt";
        String OutputFilePath = abspath + "output.txt";
        
        BufferedReader lector = null;
        FileWriter writer = null;
        
        //Si, no es com has explicat pero com no estaba en aquella clase m'he buscat la vida. Basicament creem un lector que llegeix el document de entrada i un escriptor que escriura al document de sortida.
        try {
            lector = new BufferedReader(new FileReader(InputFilePath));
            writer = new FileWriter(OutputFilePath);

            //Una variable on emmagetzarem la linea que estem llegint del document d'entrada.
            String linia;
            
            //un bucle que es repeteix mentres quedin caracter que llegir al document.
            while ((linia = lector.readLine()) != null) {
                //Pasem el String linia a un array de chars.
                char[] arrayLinia = linia.toCharArray();
                for(int i = 0; i<arrayLinia.length;i++){
                    //Escribim el caracter del costat oposat.
                    writer.write(arrayLinia[arrayLinia.length-1-i]);
                }
                //al acabar la linea en la que estem System.lineSeparator fa un enter per escriure a la següent linia
                writer.write(System.lineSeparator());
            }
            System.out.println("fitxer posat a reversa correctament " + OutputFilePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            //Intentem tancar el lector i el escriptor
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