import java.util.Scanner;

public class tresenralla {
    static int[][] tablero = {{0,0,0},{0,0,0},{0,0,0}};
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        tresenralla.act_screen();


    }
    public static void act_screen(){
        for(int i = 0;i<tablero.length;i++){
            for(int j = 0;i<tablero.length;j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
}
