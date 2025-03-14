package AEA3.Allotjament;

public class Habitacio extends Allotjament {
    private int numLlits;

    public Habitacio(String nom, int capacitat, int numLlits, int preciopornoche) {
        super(nom, capacitat, true, preciopornoche);
        this.numLlits = numLlits;
    }


    @Override
    public float calcularPreuPerNit() {
        float preuBase = 50;
        if (numLlits > 2) {
            preuBase += (numLlits - 2) * 20;
        }
        return preuBase;
    }

    public String mostrarInformacio() {
        return "\nNom: " + getNom() + "\nCapacitat: " + getCapacitat() + "\nDisponible: " + isDisponible();
    }
}



