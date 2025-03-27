package Java.AEA3.MasterMind;
import java.util.Arrays;
import java.util.Scanner;

public class MasterMindGame {
    CodeGenerator CG = new CodeGenerator();
    public final static char CORRECTE = '0';
    public final static char MALA_POSICIO = 'X';
    public final static char INCORRECTE = '-';
    public char[] CODE;
    public String feedback;

    public void main(String[] args) {
        CG.generate(5);
        CODE = CG.getCode();
        feedback = "";

        comprobarResposta("abeco");
        System.out.println(feedback);

    }

    public void comprobarResposta(String p){
        char[] input = p.toCharArray();
        for(int i = 0;i<input.length;i++){
            if(conteLletra(CODE, input[i])){
                feedback = (feedback != null?feedback + (input[i] == CODE[i]?'O':'X'):(input[i] == CODE[i]?"O":"X"));
            }
            else{
                feedback = (feedback != null?feedback + '-':"-");
            }
        }
    }
    public boolean conteLletra(char[] code, char c){
        for(int i = 0; i<code.length;i++){
            if(code[i] == c){
                return true;
            }
        }
        return false;
    }
}
