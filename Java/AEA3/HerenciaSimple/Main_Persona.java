package Java.AEA3.HerenciaSimple;

public class Main_Persona {
    public static void main(String[] args){

        Persona p1 = new Persona("Carolina", "puta",45, "Calle tu madre 34");
        p1.stats();
        System.out.println();
        String[] Assignatures = {"Programacio","Base de dades","Sistemes"};
        int[] notes = {7,4,1};
        Estudiant e1 = new Estudiant("Imbecil", "1", 23, "Zorra 46", "Dam", Assignatures, "Prat Educacio", notes);
        e1.stats();
    }    
}
