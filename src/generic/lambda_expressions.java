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
    public String noise(){return "Hissss";}  // maybe
}
class Fish extends Animal{
    Fish(String name){
        super(name);
        cover=Cover.SCALES;
    }
}










// interface for tester class
interface animal_tester {
//  This is a "functional interface": it may contain one or more default or
//  static methods but only one abstract method.
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

// some helper members
    private List<Animal> look_for_paws(List<Animal> list_animals, int i) {
        List<Animal> return_value = new ArrayList<>();
        for (Animal animal:list_animals) {
            if(i==animal.paws)
                return_value.add(animal);
        }
        return return_value;
    }

    private List<Animal> look_with_tester_class(List<Animal> list_animals, animal_tester tac) {
        List<Animal> return_value = new ArrayList<>();
        for (Animal animal:list_animals)
            if (tac.test(animal))
                return_value.add(animal);

        return return_value;
    }

// start from here
    public void go(){
// some data
        Animal Felix = new Cat("Felix")
                , Rio=new Ostrich("Rio")
                , Nemo=new Fish("Nemo")
                , Tom = new Cat("Tom")
                ;
// populate list
        List<Animal> list_animals = new ArrayList<>(List.of(Felix, Rio, Nemo, Tom));




//------------------------------ step 1 ----------------------------
// look for animals with 2 paws using a simple loop on the list
        List<Animal> result_list=look_for_paws(list_animals,2);
        for (Animal animal:result_list)
            System.out.println( "Normal loop: "+animal.getClass()+" `"+animal.get_name()+"` has `"+animal.paws+"` paws.");
// now what if I want to look for animals with 2 paws and feathers?  Or animals with 2 paws called "Rio"?
// I'd have to write many methods similar to look_for_paws.







//------------------------------ step 2 ----------------------------
// Or, I could implement a functional interface and then pass a class with the needed tests inside
        result_list= look_with_tester_class(list_animals, new test_animal_criteria());
        for (Animal animal:result_list)
            System.out.println( "Tester class: "+animal.getClass()+" `"+animal.get_name()+"` has `"+animal.paws+"` paws.");









//------------------------------ step 3 ----------------------------
// Or, I could use an anonymous class so I have my criteria always under my eye:
        result_list= look_with_tester_class(list_animals, new animal_tester() {
            public boolean test(Animal a) {
                return a.paws==2 && a.get_name().equals("Rio");
            }
        });
        for (Animal animal:result_list)
            System.out.println( "Anonymous function: "+animal.getClass()+" `"+animal.get_name()+"` has `"+animal.paws+"` paws.");










//------------------------------ step 4 ----------------------------
// Or I could use a (drumroll) LAMBDA FUNCTION!
        result_list= look_with_tester_class(list_animals
                ,   (Animal a) -> a.get_name().equals("Rio") && 2==a.paws
        );
        for (Animal animal:result_list)
            System.out.println( "Lambda expression: "+animal.getClass()+" `"+animal.get_name()+"` has `"+animal.paws+"` paws.");
    }

}

