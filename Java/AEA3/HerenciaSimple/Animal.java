package Java.AEA3.HerenciaSimple;

public class Animal {

    private static int id;

    public Animal(){
        //++id;
    }

    public int getId() {
        return id;
    }

    public void setId(int nId) {
        id = nId;
    }

    public void sound() {
        System.out.println("By default it is mute");
    }
}
