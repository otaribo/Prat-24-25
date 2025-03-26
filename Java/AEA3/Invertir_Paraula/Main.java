package Java.AEA3.Invertir_Paraula;

public class Main {
    public static void main(String[] args) {
        System.out.println(invertir("Marina apruebame"));
    }

    public static String invertir(String p){
            if(p.isEmpty()){
                return "";
            }
        return invertir(p.substring(1)) + p.charAt(0);
    }
}
