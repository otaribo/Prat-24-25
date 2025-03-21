package Java.AEA3.SistemaDeReservas;
import java.util.ArrayList;

import Java.AEA3.SistemaDeReservas.Allotjaments.Allotjament;

public class iterativeSort {
    public void insertionSort(ArrayList<Allotjament> lista, boolean orden) {
        for (int i = 1; i < lista.size(); i++) {
            Allotjament temp = lista.get(i);
            int j = i - 1;

            while (j >= 0 && (orden==true?lista.get(j).calculPreuNit() >= temp.calculPreuNit():lista.get(j).calculPreuNit() <= temp.calculPreuNit())) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, temp);
        }
        print(lista);
    }
    
    public void print(ArrayList<Allotjament> lista){
        int numeroAllotjament = 1;
        for(Allotjament allotjament : lista){
            System.out.print(numeroAllotjament + ". ");
            allotjament.MostrarInfo();
            numeroAllotjament++;
        }
    }
}