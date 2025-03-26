package Java.AEA3.Potencia_Numero;

public class Main {
    public static void main(String[] args) {
        System.out.println(potencia(4,2));
    }
    public static int potencia(int b, int e){
        if(e<=0){
            return 1;
        }
        return b * potencia(b, (e-1));
    }
}
