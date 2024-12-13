import java.util.Scanner;
public class Exercici_2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Introdueix el numero de columnes: ");
        int[][] lista = new int[5][scan.nextInt()];
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                lista[i][j] = (int)(Math.random()*10);
                System.out.print("[" + lista[i][j] + "]");
            }
            System.out.println();
        }
        scan.close();
    }
}