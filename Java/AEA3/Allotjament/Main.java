package AEA3.Allotjament;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Allotjament> allotjaments = new ArrayList<Allotjament>();
    public static ArrayList<Allotjament> arrayTemporal = new ArrayList<Allotjament>();
    public static void main(String[] args) {
        
        Habitacio H1 = new Habitacio("habitacio1", 5, 3, 56);
        Habitacio H2 = new Habitacio("habitacio2", 5, 3, 56);
        Habitacio H3 = new Habitacio("habitacio3", 5, 3, 56);
        
        allotjaments.add(H1);
        allotjaments.add(H2);
        allotjaments.add(H3);

        lectorDatosTerminal sc = new lectorDatosTerminal();
        int opcio;
        boolean salido = false;

        while (!salido) {
            System.out.print("\033[H\033[2J");
            System.out.print("\nMenú:\n1. Mostrar allotjaments disponibles\n2. Reservar allotjament\n3. Alliberar allotjament\n4. Sortir\nTria una opció: ");
            opcio = sc.leerInt();
            switch (opcio) {
                case 1:

                    for (int i = 0; i < allotjaments.size(); i++) {
                        System.out.println("\n" + i + "." + allotjaments.get(i).mostrarInformacio());
                    }
                    pressEnterToContinue();
                    break;

                case 2:
                    System.out.println("\ntt, Quin allotjament vols reservar?");
                    for (int i = 0; i < allotjaments.size(); i++) {
                        System.out.println("\n" + i + "." + allotjaments.get(i).mostrarInformacio());
                    }
                    int id = sc.leerInt();
                    if (id > 0 && id <= allotjaments.size()) {
                        allotjaments.get(id).reservar();
                    }
                    break;

                case 3:
                    System.out.println("\ntt, Quin allotjament vols alliberar?");
                    arrayTemporal(false);
                    for(Allotjament A:arrayTemporal){
                        System.out.println("\n" + A.mostrarInformacio());
                    }
                    id = sc.leerInt();
                    if (id > 0 && id <= arrayTemporal.size()) {
                        arrayTemporal.get(id).alliberar();
                    }

                case 4:
                    System.out.println("Sortint...");
                    salido = true;
            }
        }
    }
    public static void arrayTemporal(boolean disponible){
        for (int i = 0; i < allotjaments.size(); i++) {
            if(disponible?allotjaments.get(i).isDisponible():!allotjaments.get(i).isDisponible()){
                arrayTemporal.add(allotjaments.get(i));
            };
        }
    } 

    public static void pressEnterToContinue(){ 
        System.out.println("\nPrem Enter per continuar...");
        try{
            System.in.read();
        }  
        catch(Exception e){}  
    }
}
