package Java.UF1.AEA2.Exercicis_repàs_AEA2.Exercici_3;
import java.util.Scanner;
public class Exercici_3 {
    public static void main(String[] args){
        System.out.println("\033[H\033[2J");
        Scanner scan = new Scanner(System.in);
        System.out.print("Introdueix el numero de columnes: ");
        int longitud = scan.nextInt();
        System.out.print("Introdueix el numero de files: ");
        int altura = scan.nextInt();
        int[][] lista1 = new int[longitud][altura];
        int[][] lista2 = new int[longitud][altura];
        int[][] resultado = new int[longitud][altura];
        matriu(lista1, scan, 1);
        matriu(lista2, scan, 2);
        System.out.println("\033[H\033[2J");
        System.out.println("Matriu 1");
        mostrarmatriu(lista1);
        System.out.println("--------------------------------------------");
        System.out.println("Matriu 2");
        mostrarmatriu(lista2);
        System.out.println("\nLa matriu resultant de la suma de les matrius 1 i 2 es :");
        sumar(lista1, lista2, resultado);
        mostrarmatriu(resultado);
    }
    

    public static void matriu(int[][] lista, Scanner scan, int numero){
        int posicions_maximes = lista.length * lista[0].length;
        int posicions_restants = posicions_maximes;
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                System.out.println("\033[H\033[2J");
                System.out.println("Matriu " + numero);
                System.out.println("Valor per la posicio " + (posicions_maximes - posicions_restants + " / " + posicions_maximes));
                lista[i][j] = scan.nextInt();
                posicions_restants--;
                
            }
        }
    }

    public static void mostrarmatriu(int[][] lista){
        for(int i = 0;i<lista.length;i++){for(int j = 0;j<lista[i].length;j++){System.out.print("[" + lista[i][j] + "]");}System.out.println();}
    }

    public static void sumar(int[][] lista1, int[][] lista2, int[][] resultado){
        for(int i = 0;i<resultado.length;i++){
            for(int j = 0;j<resultado[i].length;j++){
                resultado[i][j] = lista1[i][j] + lista2[i][j];
            }
        }
    }
}
