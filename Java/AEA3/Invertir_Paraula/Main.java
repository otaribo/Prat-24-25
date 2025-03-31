package Java.AEA3.Invertir_Paraula;

public class Main {
    public static void main(String[] args) {
        System.out.println(invertir("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
    }

    public static String invertir(String p){
            if(p.isEmpty()){
                return "";
            }
        return invertir(p.substring(1)) + p.charAt(0);
    }
}
