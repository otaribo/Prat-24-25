import java.util.Scanner;
public class valorcolumnesv2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int filas = scan.nextInt();
        int columnas = scan.nextInt();
        String[][] taula = new String[filas][columnas];
        for(int i = 0; i<taula.length;i++){
            for(int j = 0;j < taula[i].length;j++){
                if(i%2==0&&j%2==0){
                    taula[i][j] = "a";
                    Print(taula, i, j);
                }
                else if(i%2==0&&j%2!=0){
                    taula[i][j] = "z";
                    Print(taula, i, j);
                }
                else if(i%2!=0&&j%2==0){
                    taula[i][j] = "2";
                    Print(taula, i, j);
                }
                else if(i%2!=0&&j%2!=0){
                    taula[i][j] = "-";
                    Print(taula, i, j);
                }
            }
            System.out.println();
        }
    }
    public static void Print(String[][] taula, int i, int j){
        System.out.print("[" + taula[i][j] + "]");
    }
}