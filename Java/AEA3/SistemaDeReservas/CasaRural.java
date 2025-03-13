package Java.AEA3.SistemaDeReservas;

public class CasaRural extends Allotjament {
    String Tipus = "Casa Rural";
    boolean Jardi;
    boolean Piscina;
    public CasaRural(String nom, int capacitat, boolean disponible, boolean jardi, boolean piscina){
        super(nom, capacitat, disponible);
        this.Jardi = jardi;
        this.Piscina = piscina;
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
        System.out.println(Tipus + ": " + Nom + " |" +" Capacitat: " + getCapacitat() + " |" + " Jardi: " + (isJardi() ? "Sí":"No") + " |" + " Piscina: " + (isPiscina()? "Sí":"No"));
    }
}
