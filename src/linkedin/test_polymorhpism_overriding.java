package linkedin;

abstract class Animal {
    Animal(){
        System.out.print("I am an animal. ");
    }
    abstract void noise();
}

class Cat extends Animal {
    Cat(){
        super();
        System.out.print("Specifically a cat. ");
    }
    void noise() { // overriding abstract method in linkedin.Animal
        System.out.println("I go 'Meow'.");
    }
}

class Dog extends Animal{
    Dog(){
        super();
        System.out.print("Specifically a dog. ");
    }
    void noise() { // overriding abstract method in linkedin.Animal
        System.out.println("I go 'Bark'.");
    }
}

public class test_polymorhpism_overriding {
    public void go() {
        Cat cat = new Cat();
        cat.noise();

        Dog dog = new Dog();
        dog.noise();

        System.out.println("cat is instance of animal? "+(cat instanceof Animal));
    }

}
