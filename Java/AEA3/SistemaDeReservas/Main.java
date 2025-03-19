package Java.AEA3.SistemaDeReservas;
import java.util.Scanner;

import Java.AEA3.SistemaDeReservas.Allotjaments.*;

import java.util.ArrayList;
public class Main {
    
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Allotjament> AllotjamentsLliures = new ArrayList<Allotjament>(); 
    public static CreacioAllotjaments creacioApartaments = new CreacioAllotjaments();
    public static Filtre filtre = new Filtre(0,false,false,false);
    public static void main(String[] args) {
        boolean activitatActiva = true;
        CreacioAllotjaments.creacioAllotjaments();
        do{
            menu();
        }while(activitatActiva);
    }

    public static void menu(){
        System.out.print("\033[H\033[2J");
        System.out.println("Filtre:\nPreu maxim: " + filtre.getPreuMax() +" | "+ "Cuina: " + (filtre.isCuina()==true?"Sí":"No") +" | "+ "Jardi: " + (filtre.isJardi()==true?"Sí":"No") +" | "+ "Piscina: " + (filtre.isPiscina()==true?"Sí":"No"));
        System.out.println("\n");
        boolean opcioValida = false;
        System.out.println(
            """     
            1. Mostrar Allotjaments Disponibles\n
            2. Reservar Allotjament\n
            3. Alliberar Allotjaments\n
            4. Filtre\n
            5. Sortir
            """ 
        );
        do{
            try{
                int eleccio = scan.nextInt();
                switch(eleccio){
                    case 1:
                        mostrarAllotjaments(true,true);
                        opcioValida = true;
                        break;
                    case 2:
                        reservaroAlliberarAllotjament(true);
                        opcioValida = true;
                        break;
                    case 3:
                        reservaroAlliberarAllotjament(false);
                        opcioValida = true;
                        break;
                    case 4:
                        filtre.mostrarFiltre();
                        opcioValida = true;
                        break;
                    case 5:
                        opcioValida = true;
                        System.exit(0);
                        break;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Introdueix una opcio valida");
            }
        }while(!opcioValida);
        menu();
    }

    

    public static void mostrarAllotjaments(boolean disponible, boolean clear){
        if(clear){System.out.print("\033[H\033[2J");}
        AllotjamentsLliures.clear();
        System.out.println(disponible ? "\nAllotjaments disponibles: \n" : "\nAllotjaments Ocupats: \n");
        int NumeroAllotjament = 1;
        for(Allotjament allotjament : CreacioAllotjaments.Allotjaments){
            if(disponible ? (allotjament.isDisponible()):!allotjament.isDisponible()){
                if(disponible){
                    if(allotjament.calculPreuNit()>filtre.getPreuMax()){
                        continue;
                    }
                    if(filtre.isCuina()){
                        if(allotjament instanceof Apartament){
                            Apartament apartament = (Apartament) allotjament;
                            if(!apartament.isCuina()){continue;}
                        }
                        else{
                            continue;
                        }
                    }
                    if(filtre.isJardi()){
                        if(allotjament instanceof CasaRural){
                            CasaRural casaRural = (CasaRural) allotjament;
                            if(!casaRural.isJardi()){continue;}
                        }
                        else{
                            continue;
                        }
                    }
                    if(filtre.isPiscina()){
                        if(allotjament instanceof CasaRural){
                            CasaRural casaRural = (CasaRural) allotjament;
                            if(!casaRural.isPiscina()){continue;}
                        }
                        else{
                            continue;
                        }
                    }
                    System.out.print(NumeroAllotjament+". ");
                    allotjament.MostrarInfo();
                    AllotjamentsLliures.add(allotjament);
                    NumeroAllotjament++;
                }
                else{
                    System.out.print(NumeroAllotjament+". ");
                    allotjament.MostrarInfo();
                    AllotjamentsLliures.add(allotjament);
                    NumeroAllotjament++;
                }
                
            }
        }
        if(clear){pressEnterToContinue();}
    }

    public static void reservaroAlliberarAllotjament(boolean disponible){
        System.out.print("\033[H\033[2J");
        int eleccio;
        System.out.println("\n");
        System.out.println(disponible?"Reservar:":"Alliberar:");
        mostrarAllotjaments(disponible,false);
        boolean eleccioValida = false;
        do{
            try{
                
                if (AllotjamentsLliures.size()==0){
                    System.out.println("No hi han allotjaments per veure en aquest moment");
                    pressEnterToContinue();
                    break;
                }
                System.out.print("Selecciona una opcio: ");
                eleccio = scan.nextInt();
                if(eleccio <= AllotjamentsLliures.size()){
                    eleccio--;
                    AllotjamentsLliures.get(eleccio).cambiarDisponibilitat();
                    System.out.println("\nS'ha cambiat la disponibilitat del allotjament " + AllotjamentsLliures.get(eleccio).getNom());
                    eleccioValida = true;
                    pressEnterToContinue();
                }
                else{
                    System.out.print("Selecciona una opcio valida:");
                }
            }catch(IndexOutOfBoundsException exception){
                System.out.print("Selecciona una opcio valida:");
            }
        }while(!eleccioValida);
    }
    public static void pressEnterToContinue(){ 
        System.out.println("\nPrem Enter per continuar...");
        try{
            System.in.read();
        }  
        catch(Exception e){}  
    }
}
