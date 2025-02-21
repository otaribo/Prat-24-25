package Java.AEA3.Tres_en_ralla_modular;


public class TicTacToeActivitat {
    private static int torn;
    public static void main(String[] args) {
        JocActivitat joc = new JocActivitat();
        while(true){
           joc.imprimir_tauler(); 
           joc.eleccio_usuari(torn);
           torn++;
        }
        

    }
}
