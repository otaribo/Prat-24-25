package Java.AEA3.HerenciaSimple;

public class Estudiant extends Persona {
    private String Curs;
    private String[] Assignatures;
    private String Escola;
    private int[] Notes;

    public Estudiant(String dNom, String dCognom, int dEdat, String dAdreça, String dCurs, String[] dAssignatures, String dEscola, int[] dNotes){
        super(dNom, dCognom, dEdat, dAdreça);
        this.Curs = dCurs;
        this.Assignatures = dAssignatures;
        this.Escola = dEscola;
        this.Notes = dNotes;
    }

    public String getCurs() {
        return Curs;
    }

    public void setCurs(String curs) {
        Curs = curs;
    }

    public String[] getAssignatures() {
        return Assignatures;
    }

    public void setAssignatures(String[] assignatures) {
        Assignatures = assignatures;
    }

    public String getEscola() {
        return Escola;
    }

    public void setEscola(String escola) {
        Escola = escola;
    }

    public int[] getNotes() {
        return Notes;
    }

    public void setNotes(int[] notes) {
        Notes = notes;
    }
    
    @Override
    public void stats(){
        System.out.println("Soc de la clase "+this.getClass()+" amb id: "+ this.getId());
        System.out.println("Nom:            "+this.getNom());
        System.out.println("Cognom:         "+this.getCognom());
        System.out.println("Edat:           "+this.getEdat());
        System.out.println("Adreça:         "+this.getAdreça());
        System.out.println("Curs:           "+this.getCurs());
        System.out.println("Escola:         "+this.getEscola());
        System.out.println();
        this.print_notes();
    }
    public void print_notes(){
        for (int i = 0; i<this.Assignatures.length;i++){
            System.out.println(this.Assignatures[i]+" te una nota de "+ this.Notes[i]);
        }
    }
}
