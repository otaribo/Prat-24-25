import java.util.Scanner;
public class Exercici2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int longitud = -1;
        System.out.println("Quina sera la longitud del vector?");
        do{
            longitud = NoErrorInput(scan);
        }
        while(longitud<1);
        int[] vector = new int[longitud];
        llenar_vector(vector, scan);

        System.out.println("Introdueix el valor a buscar:");
        int BuscarValor = NoErrorInput(scan);
        boolean trobat = false;
        int posicio = 0;
        for(int i = 0;i<vector.length;i++){
            if(BuscarValor==vector[i]){
                posicio = vector[i];
               trobat=true; 
            }
        }
        if(trobat){
            System.out.println("El valor s'ha trobat a la posicio " + posicio);
        }
        else{
            System.out.println("El valor no s'ha trobat a dins del vector");
        }
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
