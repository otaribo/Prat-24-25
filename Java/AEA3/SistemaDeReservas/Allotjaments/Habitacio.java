package Java.AEA3.SistemaDeReservas.Allotjaments;

public class Habitacio extends Allotjament {
    int Llits;
    
    public Habitacio(String nom, int capacitat, boolean disponible, int llits){
        super(nom, capacitat, disponible);
        this.Llits = llits;
        this.PreuBase = 50;
        this.Tipus = "Habitacio";
    
    }
    public int getLlits() {
        return Llits;
    }
    public void setLlits(int llits) {
        Llits = llits;
    }
    @Override
    public void MostrarInfo(){
        System.out.println(getTipus() + ": " + getNom() + " |" +" Capacitat: " + getCapacitat() + " |" + "Numero de Llits: " + getLlits() + " |" + "Preu per nit: " + calculPreuNit() + " euros");
    }

    public double calculPreuNit(){
            return ((getPreuBase() + (getLlits()>3?20*(getLlits()-3):0))*Filtre.getNumeroNits());
    }
}
