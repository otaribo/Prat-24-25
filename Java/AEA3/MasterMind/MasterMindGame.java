package Java.AEA3.MasterMind;
import java.util.Arrays;
import java.util.Scanner;

public class MasterMindGame {
    private static CodeGenerator CG = new CodeGenerator();
    private static PlayerHuman PH = new PlayerHuman();
    Scanner scan = new Scanner(System.in);
    public static char[] CODE;
    public static String feedback;

        """
                pruebas
                """;
    public static void main(String[] args) {
        boolean continuar = true;
        while(continuar){
            feedback = "";
            CG.generate(3);
            CODE = CG.getCode();
            System.out.println(Arrays.toString(CODE));
            while (!victoria()){
                comprobarResposta(PH.Input(CODE));
                System.out.println(feedback);
            }
            System.out.println("Molt be!!! Ho has encertat!!!");
        }
    }
    public static void comprobarResposta(String p){
        feedback = "";
        for(int i = 0;i<p.length();i++){
            if(conteLletra(CODE, p.charAt(i))){
                feedback = (feedback != null?feedback + (p.charAt(i) == CODE[i]?'O':'X'):(p.charAt(i) == CODE[i]?"O":"X"));
            }
            else{
                feedback = (feedback != null?feedback + '-':"-");
            }
        }
    }
    public static boolean conteLletra(char[] code, char c){
        for(int i = 0; i<code.length;i++){
            if(code[i] == c){
                return true;
            }
        }
        return false;
    }  
    public static boolean victoria(){
        String correct = "O".repeat(CODE.length);
        if(feedback.equals(correct)){
            return true;
        }
        else{
            return false;
        }
    }
}
