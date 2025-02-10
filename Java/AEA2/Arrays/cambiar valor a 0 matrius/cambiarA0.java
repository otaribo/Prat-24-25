import java.util.Scanner;
public class cambiarA0{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int llargada_llista = scan.nextInt();
        int[][] llista = new int[llargada_llista][5];
        
        for (int i = 0;i<llista.length;i++){
            for(int j = 0;j<llista[i].length;j++){
                llista[i][j] = i;
                if(i%2==0){
                    llista[i][j] = 0;
                }
                System.out.print("[" + llista[i][j] + "]");
            }
            System.out.println();
        }
    }
}



int a = 2;

a += 3;

a == 5;