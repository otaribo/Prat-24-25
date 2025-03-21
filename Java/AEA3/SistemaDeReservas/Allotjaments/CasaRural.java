package Java.AEA3.SistemaDeReservas.Allotjaments;


public class CasaRural extends Allotjament {
    boolean Jardi;
    boolean Piscina;
    public CasaRural(String nom, int capacitat, boolean disponible, boolean jardi, boolean piscina){
        super(nom, capacitat, disponible);
        this.Jardi = jardi;
        this.Piscina = piscina;
        this.preuNit = calculPreuNit();
        this.PreuBase = 150;
        this.Tipus = "Casa Rural";
        
    }
    public String getTipus() {
        return Tipus;
    }
    public void setTipus(String tipus) {
        Tipus = tipus;
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

    @Override
    public void MostrarInfo(){
        System.out.println(getTipus() + ": " + getNom() + " |" +" Capacitat: " + getCapacitat() + " |" + " Jardi: " + (isJardi() ? "Sí":"No") + " |" + " Piscina: " + (isPiscina()? "Sí":"No") + " |" + "Preu per nit: " + calculPreuNit() + " euros");
    }

    public double calculPreuNit(){
        if(isPiscina()){
            return ((getPreuBase() + 50)*Filtre.getNumeroNits());
        }
        else{
            return (getPreuBase()*Filtre.getNumeroNits());
        }
    }
}
