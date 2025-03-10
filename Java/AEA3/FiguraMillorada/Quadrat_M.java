package Java.AEA3.FiguraMillorada;

public class Quadrat_M extends Figura_M {
    private int costat;

    public Quadrat_M(){
        super("quadrat");
    }

    public Quadrat_M(int a){
        super("quadrat");
        this.costat = a;
    }

    public int getCostat() {
        return costat;
    }

    public void setCostat(int costat) {
        this.costat = costat;
    }

    @Override
    public double calcularArea(){
        return Math.pow(getCostat(), 2);
    }
}