package Java.AEA3.HerenciaSimple;

public class Main_Animal {
    public static void main(String[] args) {
        //animal
        Animal a = new Animal();
        //animal crida la funció sound();
        a.sound();

        Animal a1 = new Animal();
        //animal crida la funció sound();
        a1.sound();

        //dog
        Dog d = new Dog();
        //dog crida la funció sound();
        d.sound();

        //dog
        Dog d1 = new Dog();
        //dog crida la funció sound();
        d1.sound();

        Dog d2 = new Dog(23);
        //dog crida la funció sound();
        d2.sound();

        Cat c1 = new Cat();
        c1.sound();

        Cat c2 = new Cat();
        c2.sound();
    }
}
