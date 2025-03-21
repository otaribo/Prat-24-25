package Java.AEA3.SistemaDeReservas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Filtre {
    public static Scanner scan = new Scanner(System.in);
    boolean Cuina;
    boolean Jardi;
    boolean Piscina;
    boolean Orden;
    double PreuMax;
    public Filtre(double preuMax, boolean cuina, boolean jardi, boolean piscina, boolean orden){
        this.PreuMax=preuMax;
        this.Cuina=cuina;
        this.Jardi=jardi;
        this.Piscina=piscina;
        this.Orden=orden;
    }
    
    public boolean isOrden() {
        return Orden;
    }

    public void setOrden(boolean orden) {
        Orden = orden;
    }

    public boolean isCuina() {
        return Cuina;
    }

    public void setCuina(boolean cuina) {
        Cuina = cuina;
    }

    public boolean isJardi() {
        return Jardi;
    }

    public void setJardi(boolean jardi) {
        Jardi = jardi;
    }

    public boolean isPiscina() {
        return Piscina;
    }

    public void setPiscina(boolean piscina) {
        Piscina = piscina;
    }

    public double getPreuMax() {
        return PreuMax;
    }

    public void setPreuMax(double preuMax) {
        PreuMax = preuMax;
    }

    public void mostrarFiltre(){
        boolean sortir = false;
        do{
            System.out.print("\033[H\033[2J");
            System.out.println("Filtre:\n\n1. Preu maxim: " + getPreuMax() + "\n2. Cuina: " + (isCuina()==true?"Sí":"No") + "\n3. Jardi: " + (isJardi()==true?"Sí":"No") + "\n4. Piscina: " + (isPiscina()==true?"Sí":"No") + "\n5. Orden: " + (isOrden()==true?"Asc":"Desc") + "\n6. Tornar");
            try{
                int eleccio = scan.nextInt();
                switch(eleccio){
                    case 1:
                        boolean opcioValida = false;
                        do{
                            try{
                                System.out.print("Introdueix un valor: ");
                                double nouPreuMax = scan.nextDouble();
                                setPreuMax(nouPreuMax);
                                opcioValida = true;
                            }
                            catch(NumberFormatException | InputMismatchException ex){
                                System.out.println("Introdueix un valor valid");
                                scan.next();
                            } 
                        }
                        while(!opcioValida);
                        break;
                    case 2:
                        setCuina(isCuina()==true?false:true);
                        break;
                    case 3:
                        setJardi(isJardi()==true?false:true);
                        break;
                    case 4:
                        setPiscina(isPiscina()==true?false:true);
                        break;
                    case 5:
                        setOrden(isOrden()==true?false:true);
                        break;
                    case 6:
                        sortir = true;
                        break;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Introdueix una opcio valida");
            }
        }while(!sortir);
    }
}
