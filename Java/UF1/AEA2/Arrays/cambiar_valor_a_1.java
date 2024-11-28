import java.util.Scanner;
public class cambiar_valor_a_1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int llargada_llista = scan.nextInt();
        int[][] llista = new int[llargada_llista][5];
        
        for (int i = 0;i<llista.length;i++){
            for(int j = 0;j<llista[i].length;j++){
                if(i%2==0&&j%2==0){
                    llista[i][j] = 1;
                }
                else{
                    llista[i][j] = 0;
                }
                if(llista[i][j] == 1){
                    System.out.print("\033[31m" + "[" + llista[i][j] +"]");
                }
                else{
                    System.out.print("\033[97m" + "[" + llista[i][j] +"]");
                }
                
                System.out.print(" ");

            }
            System.out.println("\033[0m");
        }
    }
}