package Java.AEA3.SistemaDeReservas;
import java.util.ArrayList;

import Java.AEA3.SistemaDeReservas.Allotjaments.Allotjament;
import Java.AEA3.SistemaDeReservas.Allotjaments.Apartament;
import Java.AEA3.SistemaDeReservas.Allotjaments.CasaRural;
import Java.AEA3.SistemaDeReservas.Allotjaments.Habitacio;

public class CreacioAllotjaments {
    public static ArrayList<Allotjament> Allotjaments = new ArrayList<Allotjament>();
    public CreacioAllotjaments(){

    }

    public static void creacioAllotjaments(){
        CasaRural CasaRural1 = new CasaRural("Casa de camp", 6, true, false, true);
        Allotjaments.add(CasaRural1);
        CasaRural CasaRural2 = new CasaRural("Bungalows", 5, false, true, false);
        Allotjaments.add(CasaRural2);
        CasaRural CasaRural3 = new CasaRural("Casa Muntanya", 7, true, true, false);
        Allotjaments.add(CasaRural3);
        CasaRural CasaRural4 = new CasaRural("Casa de poble", 3, true, true, false);
        Allotjaments.add(CasaRural4);
        Apartament apartament1 = new Apartament("Apartament Barcelona", 4, true, true, 3);
        Allotjaments.add(apartament1);
        Apartament apartament2 = new Apartament("Apartament Sevilla", 5, true, false, 3);
        Allotjaments.add(apartament2);
        Apartament apartament3 = new Apartament("Apartament Madrid", 1, true, false, 1);
        Allotjaments.add(apartament3);
        Apartament apartament4 = new Apartament("Apartament Huesca", 2, true, true, 2);
        Allotjaments.add(apartament4);
        Habitacio habitacio1 = new Habitacio("Habitacio Petita", 1, true, 1);
        Allotjaments.add(habitacio1);
        Habitacio habitacio2 = new Habitacio("Habitacio Mitjana", 2, true, 1);
        Allotjaments.add(habitacio2);
        Habitacio habitacio3 = new Habitacio("Habitacio Gran", 5, true, 4);
        Allotjaments.add(habitacio3);
        Habitacio habitacio4 = new Habitacio("Habitacio molt gran", 7, false, 5);
        Allotjaments.add(habitacio4);
    }
}
