package Java.AEA3.HerenciaSimple;

public class Persona {
    private int id;
    private String Nom;
    private int Edat;
    private String Cognom;
    private String Adreça;

    public Persona(String dNom, String dCognom, int dEdat, String dAdreça){
        id = setId();
        Nom = dNom;
        Cognom = dCognom;
        Edat = dEdat;
        Adreça = dAdreça;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public int getEdat() {
        return Edat;
    }

    public String getCognom() {
        return Cognom;
    }

    public String getAdreça() {
        return Adreça;
    }

    private int setId() {
        MaxId.Max_Id = MaxId.Max_Id+1;
        return MaxId.Max_Id;
    }
    public void stats(){
        System.out.println("Soc de la clase "+this.getClass()+" amb id: "+ this.getId());
        System.out.println("Nom:            "+this.getNom());
        System.out.println("Cognom:         "+this.getCognom());
        System.out.println("Edat:           "+this.getEdat());
        System.out.println("Adreça:         "+this.getAdreça());
    }
}
