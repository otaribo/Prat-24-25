package Java.AEA3.SistemaDeReservas.Allotjaments;
import java.util.ArrayList;

public class InsertionSort {

    public static void insertionSort(ArrayList<Producte> productes) {
        for (int i = 1; i < productes.size(); i++) {
            Producte key = productes.get(i);
            int j = i - 1;

            while (j >= 0 && productes.get(j).getPreuBase() > key.getPreuBase()) {
                productes.set(j + 1, productes.get(j));
                j = j - 1;
            }
            productes.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        ArrayList<Producte> productes = new ArrayList<Producte>();
            Producte p1 = new Producte("Producte A", 100.0);
            productes.add(p1);
            Producte p2 = new Producte("Producte B", 50.0);
            productes.add(p2);
            Producte p3 = new Producte("Producte C", 200.0);
            productes.add(p3);
            Producte p4 = new Producte("Producte D", 75.0);
            productes.add(p4);

        System.out.println("Llista abans de ordenar:");
        productes.forEach(System.out::println);

        insertionSort(productes);

        System.out.println("\nLlista després de ordenar:");
        productes.forEach(System.out::println);
    }
}