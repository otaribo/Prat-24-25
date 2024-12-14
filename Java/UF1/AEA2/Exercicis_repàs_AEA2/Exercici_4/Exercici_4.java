package Java.UF1.AEA2.Exercicis_repàs_AEA2.Exercici_4;
import java.util.Random;
import java.util.Arrays;
public class Exercici_4 {
    public static void main(String[] args){
        Random random = new Random();
        int[] lista = new int[random.nextInt(200)];
        for(int i = 0;i<lista.length;i++){
            lista[i] = random.nextInt(999);
        }
        Arrays.sort(lista);
        if(lista.length>2){
            System.out.println("La llista te " + lista.length + " espais " + "el segon numero mes petit es " + lista[1]);
        }
        else{
            System.out.println("La llista te " + lista.length + " espai " + "El segon numero mes petit de la llista es " + lista[0]);
        }
        
    }
}
