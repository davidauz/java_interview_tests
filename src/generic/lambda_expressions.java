package generic;

import java.util.ArrayList;
import java.util.List;

enum Cover
{   FUR
,   FEATHERS
,   SCALES
};

// base class
class Animal{
    public int paws=0;
    private String m_name;
    public Cover cover;
    public Animal(String name){m_name=name;}
    public String noise(){return "silent";}
    public String get_name() {return m_name;}
}





// derived classes
class Cat extends Animal{
    Cat(String name){
        super(name);
        paws=4;
        cover= Cover.FUR;
    }
    public String noise(){return "Meow";}
}

class Ostrich extends Animal{
    Ostrich(String name){
        super(name);
        paws=2;
        cover= Cover.FEATHERS;
    }
    public String noise(){return "Honk";}  // maybe
}

class Fish extends Animal{
    Fish(String name){
        super(name);
        cover=Cover.SCALES;
    }
}






// interface for tester class
/*functional*/ interface animal_tester {
//  a "functional interface" is defined as having only one abstract method,
//  but may contain any number of default or  static methods.
    boolean test(Animal a);
}






// tester class
class test_animal_criteria implements animal_tester {
    @Override
    public boolean test(Animal a) {
        return 2==a.paws
        &&  a.get_name().equals("Rio")
        ;
    }
}






public class lambda_expressions {

// This is the most basic way
    public static List<Animal> look_for_paws(List<Animal> list_animals, int i) {
        List<Animal> animals = new ArrayList<>();
        for (Animal animal:list_animals) {
            if(i==animal.paws)
                animals.add(animal);
        }
        return animals;
    }

//This is a more advanced way
    public static List<Animal> look_with_tester_class
    (   List<Animal> animals
    ,   animal_tester tac
    ) {
        List<Animal> return_value = new ArrayList<>();
        for (Animal animal:animals)
            if (tac.test(animal))
                return_value.add(animal);

        return return_value;
    }




}

