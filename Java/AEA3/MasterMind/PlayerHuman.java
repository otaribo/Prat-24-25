package Java.AEA3.MasterMind;
import java.util.Scanner;

public class PlayerHuman extends Player {
    Scanner scan = new Scanner(System.in);
    
    @Override
    public String Input(char[] CODE){
        boolean Valid = false;
        String input = null;
        while(!Valid){
            input = scan.nextLine();
            if(input.length() == CODE.length){
                Valid = true;
            }
            else{
                System.out.println("Entrada incorrecta");
            }
        }
        return input;
    }
}
