package Java.AEA3.Tres_en_ralla_modular;

import java.util.Scanner;

public class JocActivitat {
    private Tauler tauler = new Tauler();
    private char jugadorActual;
    private boolean joc_Acabat;
    private Scanner scan = new Scanner(System.in);

    public void imprimir_tauler(){
        tauler.imprimir_tauler();
    }
    
    public void eleccio_usuari(int torn){
        boolean eleccio_valida = false;
        char x = 'x';
        char o = 'o';
        do{
            System.out.print("On vols colocar una ficha: ");
            if(scan.hasNextInt()&&(scan.nextInt()>=1&&scan.nextInt()<=9)){
                int eleccio = scan.nextInt();
                boolean disponibilitat = tauler.disponibilitat_lloc(mirar_eleccio(eleccio));
                if(disponibilitat){
                    tauler.cambiar_valor(mirar_eleccio(eleccio),torn%2==0||torn==0?x:o);
                    eleccio_valida = true;
                }
            }
            if(!eleccio_valida){scan.next();}
        }while(!eleccio_valida);
        
        
        
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

    
}
