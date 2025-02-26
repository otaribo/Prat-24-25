package Java.AEA3.HerenciaSimple;

public class Cat extends Animal {

    public Cat(){
        int id = this.getId();
        this.setId(++id);
    }

    public Cat(int id){
        this.setId(id);
    }

    private void Meow() {
        System.out.println("Cat '" + this.getId() + "' is mewing");
    }

    // Overriding super class behavior
    @Override
    public void sound() {
        Meow();
    }
}
