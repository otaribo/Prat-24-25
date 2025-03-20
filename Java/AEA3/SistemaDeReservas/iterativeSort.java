package Java.AEA3.SistemaDeReservas;
import java.util.ArrayList;

import AEA3.Allotjament.Allotjament;

public class iterativeSort {
    public void main(String[] args){
        int[] lista = new int[]{3,5,6,8,1,2,0,-3,6};
        for(int i = 0; i < lista.length;i++){
            int temp = lista[i];
            int j = i;
            while((j>0)&&(temp<lista[j-1])){
                lista[j] = lista[j-1];
                j--;
            }
            lista[j] = temp;
        }
        print(lista);  
    } 
    public void print(int[] lista){
        for(int i = 0;i<lista.length;i++){
            System.out.println(lista[i] + ", ");
        }
    }

    public void iterativeSortAllotjaments(ArrayList<Allotjament> lista){
        for(int i = 0;i<lista.size();i++){
            Allotjament temp = lista.get(i);
        }
    }
}

