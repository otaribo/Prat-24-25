package Java.UF1.AEA3.estrellasguionesnumeros;
import java.util.Scanner;
public class estrellasguionesnumeros {
    public static void main(String[] args){
        boolean activitatactiva = true;
        Scanner scan = new Scanner(System.in);
        while(activitatactiva){
            System.out.println("\033[H\033[2J");
            System.out.println("Cuantes estrelles vols?");
            int inputestrelles = scan.nextInt();
            System.out.println("Cuants guions vols?");
            int inputguions = scan.nextInt();
            System.out.println("Quin numero vols?");
            String inputnumeros2 = scan.next();
            System.out.println("Cuants cops vols que es repeteixi aquest numero?");
            int inputnumeros1 = scan.nextInt();
            System.out.println("\033[H\033[2J");
            repeticion(inputestrelles, "*");
            repeticion(inputguions, "-");
            repeticion(inputnumeros1, inputnumeros2);
            System.out.println("Vols continuar? y/n");
            String continuar = scan.next();
            if (!continuar.equals("y")){
                activitatactiva = false;
            }
        }
        scan.close();
    }
    public static void repeticion(int input, String simbolo){
        for(int i = 0;i<input;i++){
            System.out.print(simbolo);
        }
        System.out.println();
    }
}