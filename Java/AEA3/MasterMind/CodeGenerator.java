package Java.AEA3.MasterMind;

import java.util.ArrayList;
import java.util.Collections;

public class CodeGenerator {
    char[] Code;

    public char[] getCode() {
        return Code;
    }

    public void setCode(char[] code) {
        Code = code;
    }

    public void generate(int Llarg){
        ArrayList<Character> chars = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            chars.add(c);
        }
        Collections.shuffle(chars);

        char[] code = new char[Llarg];
        for (int i = 0; i < Llarg; i++) {
            code[i] = chars.get(i);
        }
        
        setCode(code);
    }
}
