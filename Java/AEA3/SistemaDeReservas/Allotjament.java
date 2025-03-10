package Java.AEA3.SistemaDeReservas;

public class Allotjament {
    String Nom;
    int Capacitat;
    boolean Disponible;

    public Allotjament(String nom, int capacitat, boolean disponible){
        this.Nom = nom;
        this.Capacitat = capacitat;
        setDisponible(disponible);
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getCapacitat() {
        return Capacitat;
    }

    public void setCapacitat(int capacitat) {
        Capacitat = capacitat;
    }

    public boolean isDisponible() {
        return Disponible;
    }
    public void setDisponible(boolean disponible){
        Disponible = disponible;
    }

    public void cambiarDisponibilitat(){
        if(isDisponible()){
            setDisponible(false);
        }
        else{
            setDisponible(true);
        }
    }
    public void MostrarInfo(){
        
    }
}
