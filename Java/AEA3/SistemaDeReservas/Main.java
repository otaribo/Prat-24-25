package Java.AEA3.SistemaDeReservas;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static ArrayList<Allotjament> Allotjaments = new ArrayList<Allotjament>();
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Allotjament> AllotjamentsLliures = new ArrayList<Allotjament>(); 
    public static void main(String[] args) {
        taulaAllotjaments();
        mostrarAllotjaments(true);
        reservarAllotjament();
        mostrarAllotjaments(true);
    }

    public static void menu(){
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
                        mostrarAllotjaments(true);
                    case 2:
                        reservarAllotjament();
                    case 3:

                    case 4:

                }
            }
            catch(NumberFormatException ex){
                System.out.println("Introdueix una opcio valida");
            }
        }while(!opcioValida);
    }

    public static void taulaAllotjaments(){
        CasaRural CasaRural1 = new CasaRural("Casa de camp", 6, true, false, true);
        Allotjaments.add(CasaRural1);
        CasaRural CasaRural2 = new CasaRural("Bungalows", 5, false, true, false);
        Allotjaments.add(CasaRural2);
    }

    public static void mostrarAllotjaments(boolean disponible){
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
    }
    public static void reservarAllotjament(){
        int eleccio;
        System.out.println("Reservar:");
        mostrarAllotjaments(true);
        boolean eleccioValida = false;
        System.out.print("Selecciona una opcio: ");
        do{
            try{
                eleccio = scan.nextInt();
                if(eleccio <= AllotjamentsLliures.size()){
                    eleccio--;
                    AllotjamentsLliures.get(eleccio).cambiarDisponibilitat();
                    System.out.println("S'ha cambiat la disponibilitat del allotjament " + AllotjamentsLliures.get(eleccio).getNom());
                    eleccioValida = true;
                }
                else{
                    System.out.print("Selecciona una opcio valida:");
                }
            }catch(IndexOutOfBoundsException exception){
                System.out.print("Selecciona una opcio valida:");
            }
        }while(!eleccioValida);
    }
}
