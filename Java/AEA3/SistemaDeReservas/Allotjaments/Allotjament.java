package Java.AEA3.SistemaDeReservas.Allotjaments;

import Java.AEA3.SistemaDeReservas.Filtre;

public class Allotjament {
    static Filtre Filtre;
    String Tipus;
    String Nom;
    int Capacitat;
    boolean Disponible;
    double PreuBase;
    double preuNit;

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
    public double getPreuBase() {
        return PreuBase;
    }
    public void setPreuBase(double preuBase) {
        PreuBase = preuBase;
    }
    public String getTipus() {
        return Tipus;
    }
    public void setTipus(String tipus) {
        Tipus = tipus;
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
    public double calculPreuNit(){
        return 0;
    }
    public static void setFiltre(Filtre filtre) {
        Filtre = filtre;
    }
    public void setPreuNit(double preuNit) {
        this.preuNit = preuNit;
    }
    public static void setFilter(Filtre filtre){
        Filtre = filtre;
    }

    public Filtre getFiltre(){
        return Filtre;
    }
}