package Tres_en_ralla_modular;

public class Tauler {
    private char[][] tauler=new char[3][3];
    
    //Alguns colors per a la meva satisfaccio personal

    public static final String Vermell = "\u001B[31m";
    public static final String Verd = "\u001B[32m";
    public static final String Blau = "\u001B[34m";
    public static final String Blanc = "\u001B[37m";
    private static final char x = 'x';
    private static final char o = 'o';

    public Tauler() {
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                tauler[i][j] = '-';
            }
        }
    }

    public void imprimir_tauler(){
        for(int i = 0;i<tauler.length;i++){
            for(int j = 0;j<tauler[i].length;j++){
                System.out.print(tauler[i][j]==x||tauler[i][j]==o?(tauler[i][j]==x?"["+Blau+tauler[i][j]+Blanc+"]":"["+Vermell+tauler[i][j]+Blanc+"]"):"["+Blanc+tauler[i][j]+"]");
            }
            System.out.println();
        }
    }
    public boolean disponibilitat_lloc(int[] Posicio){
        int i = Posicio[0];
        int j = Posicio[1];
        if (tauler[i][j]==x||tauler[i][j]==o){
            return false;
        }
        else{
            return true;
        }
    }

    public void cambiar_valor(int[] Posicio, char valor){
        int i = Posicio[0];
        int j = Posicio[1];
        tauler[i][j] = valor;
    }

    public int victoria(){

        for (int i = 0; i < 3; i++) {
            if ((tauler[i][0] == x||tauler[i][0] == o) && tauler[i][0] == tauler[i][1] && tauler[i][1] == tauler[i][2]) {
                return tauler[i][0]==x?1:2;
            }
        }

        for (int j = 0; j < 3; j++) {
            if ((tauler[0][j] == x||tauler[0][j] == o) && tauler[0][j] == tauler[1][j] && tauler[1][j] == tauler[2][j]) {
                return tauler[0][j]==x?1:2;
            }
        }

        if ((tauler[0][0] == x||tauler[0][0] == o) && tauler[0][0] == tauler[1][1] && tauler[1][1] == tauler[2][2]) {
            return tauler[0][0]==x?1:2;
        }

        if ((tauler[0][2] == x||tauler[0][2] == o) && tauler[0][2] == tauler[1][1] && tauler[1][1] == tauler[2][0]) {
            return tauler[0][2]==x?1:2;
        }
    
        return 0;
    }
}

