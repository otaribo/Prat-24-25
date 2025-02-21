package Tres_en_ralla_modular;

import java.util.Scanner;

public class JocActivitat {
    private Tauler tauler = new Tauler();
    private boolean joc_Acabat;
    private Scanner scan = new Scanner(System.in);
    private static int torn;

    public void Inici(){
        torn = 0;
        joc_Acabat = false;
        while(!joc_Acabat){
            if(tauler.victoria()==1||tauler.victoria()==2){
                System.out.println("El jugador " + (tauler.victoria()==1?'x':'o') + " ha guanyat!");
                tauler.imprimir_tauler();
                joc_Acabat = true;
            }
            else{
                System.out.println("Torn de " + (torn%2==0?tauler.Blau+"x"+tauler.Blanc:tauler.Vermell+"o"+tauler.Blanc));
                tauler.imprimir_tauler();
                eleccio_usuari(torn);
                torn++;  
            }
        }
    }
    
    public void eleccio_usuari(int torn) {
        boolean eleccio_valida = false;
        int eleccio = 0;
        char jugador = (torn % 2 == 0) ? 'x' : 'o';
    
        while (!eleccio_valida) {
            System.out.print("On vols colocar una ficha (1-9): ");
            
            if (scan.hasNextInt()) {
                eleccio = scan.nextInt();
                
                if (eleccio >= 1 && eleccio <= 9) {
                    int[] posicio = mirar_eleccio(eleccio);
                    if (tauler.disponibilitat_lloc(posicio)) {
                        tauler.cambiar_valor(posicio, jugador);
                        eleccio_valida = true;
                    } else {
                        System.out.println("Aquesta posició ja està ocupada. Tria una altra.");
                    }
                } else {
                    System.out.println("Entrada no vàlida. Si us plau, introdueix un número entre 1 i 9.");
                }
            } else {
                System.out.println("Entrada no vàlida. Si us plau, introdueix un número.");
                scan.next();
            }
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

    
}
