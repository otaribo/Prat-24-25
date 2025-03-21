package Java.AEA3.SistemaDeReservas.Allotjaments;

public class Producte {
    private String nom;
    private double preuBase;

    public Producte(String nom, double preuBase) {
        this.nom = nom;
        this.preuBase = preuBase;
    }

    public String getNom() {
        return nom;
    }

    public double getPreuBase() {
        return preuBase;
    }

    @Override
    public String toString() {
        return "Producte{" +
                "nom='" + nom + '\'' +
                ", preuBase=" + preuBase +
                '}';
    }
}