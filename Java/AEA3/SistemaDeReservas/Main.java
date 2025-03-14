package Java.AEA3.SistemaDeReservas;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static ArrayList<Allotjament> Allotjaments = new ArrayList<Allotjament>();
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Allotjament> AllotjamentsLliures = new ArrayList<Allotjament>(); 
    public static void main(String[] args) {
        boolean activitatActiva = true;
        creacioAllotjaments();
        do{
            menu();
        }while(activitatActiva);
    }

    public static void menu(){
        System.out.print("\033[H\033[2J");
        System.out.println("\n");
        boolean opcioValida = false;
        System.out.println(
            """     
            1. Mostrar Allotjaments Disponibles\n
            2. Reservar Allotjament\n
            3. Alliberar Allotjaments\n
            4. Sortir
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
                        opcioValida = true;
                        System.exit(0);
                        break;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Introdueix una opcio valida");
            }
        }while(!opcioValida);
    }

    public static void creacioAllotjaments(){
        CasaRural CasaRural1 = new CasaRural("Casa de camp", 6, true, false, true);
        Allotjaments.add(CasaRural1);
        CasaRural CasaRural2 = new CasaRural("Bungalows", 5, false, true, false);
        Allotjaments.add(CasaRural2);
        CasaRural CasaRural3 = new CasaRural("Casa Muntanya", 7, true, true, false);
        Allotjaments.add(CasaRural3);
        CasaRural CasaRural4 = new CasaRural("Casa depoble", 3, true, true, false);
        Allotjaments.add(CasaRural4);
    }

    public static void mostrarAllotjaments(boolean disponible, boolean clear){
        AllotjamentsLliures.clear();
        System.out.println(disponible ? "Allotjaments disponibles: \n" : "Allotjaments Ocupats: \n");
        int NumeroAllotjament = 1;
        for(Allotjament allotjament : Allotjaments){
            if(disponible ? allotjament.isDisponible():!allotjament.isDisponible()){
                System.out.print(NumeroAllotjament+". ");
                allotjament.MostrarInfo();
                AllotjamentsLliures.add(allotjament);
                NumeroAllotjament++;
            }
        }
        if(clear){
            pressEnterToContinue();
        }
    }

    public static void reservaroAlliberarAllotjament(boolean disponible){
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
