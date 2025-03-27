package Java.AEA3.Contar_Digits;

public class Main {
    public static void main(String[] args) {
        System.out.println(contarDigits(19074));
    }
    public static int contarDigits(int n){
        if(n < 0){
            n = n * -1;
        }
        if(n < 10){
            return 1;
        }
        return 1 + contarDigits(n/10) ;
    }
}
