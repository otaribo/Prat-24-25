import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Valor per la longitud");
        int longitud = NoErrorInput(scan);
        System.out.println("Valor per la altura");
        int altura = NoErrorInput(scan);
        int[][] taula = new int[longitud][altura];
        llenar_vector(taula, scan);
        for(int i= 0;i<taula.length;i++){
            for(int j= 0;j<taula.length;j++){
                System.out.print("[" + taula[i][j] +"]");
            }
            System.out.println();
        }

    }
    public static void llenar_vector(int[][] vector, Scanner scan){
        for(int i = 0;i<vector.length;i++){
            for(int j = 0;j<vector.length;j++){
                System.out.println("Posicio ["+i+"]["+j+"]");
                vector[i][j] = NoErrorInput(scan);
            }
        }
    }

    public static int NoErrorInput(Scanner scan){
        int valor = 0;
        boolean novalid = true;
        do{
            try{
                System.out.print("Introdueix un valor:");
                String numerointroduit = scan.nextLine();
                valor = Integer.parseInt(numerointroduit);
                novalid = false;
            }

            catch(NumberFormatException ex){
                    System.out.println("valor no valid");
            } 
        }
        while(novalid);
        return valor;
    }
}
