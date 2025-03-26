package Java.AEA3.Suma_Dels_Primers_N_Numeros_Enters;

public class Main { 
    public static void main(String[] args) {
        System.out.println(suma(10));
        
    }
    public static int suma(int n){
        if(n <= 0){
            return 0; 
        }
        System.out.println("Ara n val: " + n);
        return n + suma(n-1);
    }
}
