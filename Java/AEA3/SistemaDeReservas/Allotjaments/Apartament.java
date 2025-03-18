package Java.AEA3.SistemaDeReservas.Allotjaments;

public class Apartament extends Allotjament {
    
    boolean Cuina;
    int Habitacions;

    public Apartament(String nom, int capacitat, boolean disponible, boolean cuina, int habitacions){
        super(nom, capacitat, disponible);
        this.Cuina = cuina;
        this.Habitacions = habitacions<=0?1:habitacions;
        this.preuNit = calculPreuNit();
        this.PreuBase = 100;
        this.Tipus = "Apartament";
    }
    
    public boolean isCuina() {
        return Cuina;
    }
    public void setCuina(boolean cuina) {
        Cuina = cuina;
    }
    public int getHabitacions() {
        return Habitacions;
    }
    public void setHabitacions(int habitacions) {
        Habitacions = habitacions;
    }
    public double getPreuBase() {
        return PreuBase;
    }
    public void setPreuBase(double preuBase) {
        PreuBase = preuBase;
    }
   
    @Override
    public void MostrarInfo(){
        System.out.println(getTipus() + ": " + getNom() + " |" +" Capacitat: " + getCapacitat() + " |" + " Habitacions: " + getHabitacions() +" |" + " Cuina: " + (isCuina() ? "Sí":"No") + " |" + " Preu per nit: " + calculPreuNit() + " euros");
    }

    public double calculPreuNit(){
        return PreuBase+(10*Habitacions);
    }
}
