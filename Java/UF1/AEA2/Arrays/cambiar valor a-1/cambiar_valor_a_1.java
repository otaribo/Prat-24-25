import java.util.Scanner;
public class cambiar_valor_a_1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //començo demanant els valors d'amplada i llargada de la matriu al usuari.
        System.out.print("Quin numero de files vols: ");
        int llargada_llista = scan.nextInt();
        System.out.print("Quin numero de columnes vols: ");
        int amplada_llista = scan.nextInt();
        //creo la matriu en base a les dades donades per l'usuari.
        int[][] llista = new int[llargada_llista][amplada_llista];
        //utilitzo 2 "for" per poder mourem per cada element de la matriu.
        for (int i = 0;i<llista.length;i++){
            for(int j = 0;j<llista[i].length;j++){
                //comprovo si el espai en el que estic forma part d'una columna i fila que son parelles per aixi asignarli el valor "1" que mes tard sera un "-1" no ho poso aqui per tema de estetica.
                if(i%2==0&&j%2==0){
                    llista[i][j] = 1;
                }
                //en cas negatiu del "if" de mes amunt donem el valor 0.
                else{
                    llista[i][j] = 0;
                }
                //poso per pantalla el valor corresponent d'aquest punt de la matriu, no faig un intro perque aixi esta mes ordenat, apart els pinto de colors perque aixi tinguis una millor comprensio. De res ehhhhhhhhhh ;P
                if(llista[i][j] == 1){
                    System.out.print("\033[31m" + "[-" + llista[i][j] +" ]");
                }
                else{
                    System.out.print("\033[97m" + "[ " + llista[i][j] +" ]");
                }
            }
            System.out.println("\033[0m");
        }
        scan.close();
    }
}