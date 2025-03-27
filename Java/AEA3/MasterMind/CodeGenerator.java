package Java.AEA3.MasterMind;

import java.util.Random;

public class CodeGenerator {
    char[] Code;

    public char[] getCode() {
        return Code;
    }

    public void setCode(char[] code) {
        Code = code;
    }

    public void generate(int Llarg){
        Random r = new Random();
        char[] code = new char[Llarg];
        for(int i = 0; i<code.length;i++){
            code[i] = (char)(r.nextInt(26) + 'a');
        }
        System.out.println("Code has been created");
        setCode(code);
    }
}
