import java.util.Scanner;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int longitud = -1;
        System.out.println("Quina sera la longitud del vector?");
        do{
            longitud = NoErrorInput(scan);
        }
        while(longitud<1);
        int[] vector1 = new int[longitud];
        int[] vector2 = new int[longitud];
        int[] vector3 = new int[longitud];
        System.out.println("Emplena el vector 1");
        llenar_vector(vector1, scan);
        System.out.println("Emplena el vector 2");
        llenar_vector(vector2, scan);

        System.out.println("Resultado de la suma de los dos vectores");
        for(int i = 0; i<vector3.length;i++){
            vector3[i] = vector1[i] + vector2[i];
            System.out.print("["+vector3[i]+"]");
        }
        System.out.println();

        
        scan.close();
    }  
    
    public static void llenar_vector(int[] vector, Scanner scan){
        for(int i = 0;i<vector.length;i++){
            vector[i] = NoErrorInput(scan);
        }
    }


    public static int NoErrorInput(Scanner scan){
        int valor = 0;
        boolean novalid = true;
        do{
            try{
                System.out.print("Introdueix un valor: ");
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

