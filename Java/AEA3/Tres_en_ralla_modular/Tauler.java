package Java.AEA3.Tres_en_ralla_modular;

public class Tauler {
    private char[][] tauler=new char[3][3];
    
    //Alguns colors per a la meva satisfaccio personal

    public static final String Vermell = "\u001B[31m";
    public static final String Verd = "\u001B[32m";
    public static final String Blau = "\u001B[34m";
    public static final String Blanc = "\u001B[37m";

    public Tauler() {
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                tauler[i][j] = '-';
            }
        }
    }

    public void imprimir_tauler(){
        char x = 'x';
        char o = 'o';
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
        char x = 'x';
        char o = 'o';
        if (tauler[i][j]==x||tauler[i][j]==o){
            return true;
        }
        else{
            return false;
        }
    }

    public void cambiar_valor(int[] Posicio, char valor){
        int i = Posicio[0];
        int j = Posicio[1];
        tauler[i][j] = valor;
    }
}

