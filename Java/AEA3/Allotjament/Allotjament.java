package AEA3.Allotjament;

public class Allotjament {

    private String nom;
    private int capacitat;
    private boolean disponible;
    private int preciopornoche;

    public Allotjament(String nom, int capacitat, boolean disponible, int preciopornoche) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.disponible = disponible;
        this.preciopornoche = preciopornoche;
    }

    public int getPreciopornoche() {
        return preciopornoche;
    }

    public void setPreciopornoche(int preciopornoche) {
        this.preciopornoche = preciopornoche;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getCapacitat() {
        return capacitat;
    }
    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public float calcularPreuPerNit() {
        return 0;
    }

    public String mostrarInformacio() {
        return "\nNom: " + getNom() + "\nCapacitat: " + getCapacitat() + "\nDisponible: " + isDisponible();
    }

    public boolean reservar() {
        
        if (isDisponible()) {
            setDisponible(false);
            System.out.println("Allotjament reservat!");
            return true;
        }
        System.out.println("Allotjament no disponible!");
        return false;
    }

    public void alliberar() {
        if (!isDisponible()) {
            setDisponible(true);
            System.out.println("Allotjament alliberat!");
        }
        System.out.println("Allotjament ja lliure!");
    }
}
