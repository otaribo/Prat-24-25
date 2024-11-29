import java.util.Scanner;
public class tresenralla {
    static int[][] tablero = {{0,0,0},{0,0,0},{0,0,0}};
    static String[][] posicions = {{"[1]","[2]","[3]"},{"[4]","[5]","[6]"},{"[7]","[8]","[9]"}};
    static boolean joc_actiu = true;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(joc_actiu){
            act_screen();
            System.out.print("Selecciona una casella: ");
            int[] eleccio = mirar_eleccio(scan.nextInt());
            mirar_disponibilitat(eleccio);
            System.out.println("Prem enter per continuar");
            comprobar();
            scan.nextLine();
            
            
        }
    }
    public static void act_screen(){
        System.out.println("\033[H\033[2J");
        for(int i = 0;i<posicions.length;i++){
            for(int j = 0;j<posicions[i].length;j++){
                if(tablero[i][j]==1){posicions[i][j]="["+"\u001B[34m"+"x"+"\u001B[0m"+"]";}else if(tablero[i][j]==2){posicions[i][j]="["+"\u001B[31m"+"y"+"\u001B[0m"+"]";}
                System.out.print(posicions[i][j]);
            }
            System.out.println();
        }
    }
    public static int[] mirar_eleccio(int eleccio){
        switch (eleccio) {
            case 1: return new int[]{0,0};
            case 2: return new int[]{0,1};
            case 3: return new int[]{0,2};
            case 4: return new int[]{1,0};
            case 5: return new int[]{1,1};
            case 6: return new int[]{1,2};
            case 7: return new int[]{2,0};
            case 8: return new int[]{2,1};
            case 9: return new int[]{2,2};
            default: return null;
        }
    }
    public static void mirar_disponibilitat(int[] eleccio){
        if(tablero[eleccio[0]][eleccio[1]]!=1&&tablero[eleccio[0]][eleccio[1]]!=2){
            tablero[eleccio[0]][eleccio[1]] = 1;
        }
        else{
            System.out.println("Posicio no valida");
        }
    }
    public static void comprobar(){
        for(int i = 0;i<tablero.length;i++){if(((tablero[0][i]==1||tablero[0][i]==2)&&(tablero[1][i]==1||tablero[1][i]==2)&&(tablero[2][i]==1||tablero[2][i]==2))||((tablero[i][0]==1||tablero[i][0]==2)&&(tablero[i][1]==1||tablero[i][1]==2)&&(tablero[i][2]==1||tablero[i][2]==2))||((tablero[0][0]==1||tablero[0][0]==2)&&(tablero[1][1]==1||tablero[1][1]==2)&&(tablero[2][2]==1||tablero[2][2]==2))||((tablero[0][2]==1||tablero[0][2]==2)&&(tablero[1][1]==1||tablero[1][1]==2)&&(tablero[2][0]==1||tablero[2][0]==2))){act_screen();System.out.println("Has guanyat");joc_actiu=false;}}
    }
}
