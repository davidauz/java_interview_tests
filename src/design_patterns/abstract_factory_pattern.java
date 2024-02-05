package design_patterns;

//This pattern is also called `factory of factories`.
//It is a kind of factory that creates other factories.

// mammals_factory and reptilian_factory are both animal_abstract_factory

//first interface implemented by all animals
interface animal {
    public String noise();
    public String movement();
}

// second interface just for fun
interface has_fur{
    public String fur_color();
}

// concrete class 1
class Cat implements animal, has_fur {

    @Override
    public String noise() {
        return "MEOW";
    }

    @Override
    public String movement() {
        return "walk";
    }

    @Override
    public String fur_color() {
        return "striped";
    }
}

// concrete class 2
class Kangaroo implements animal, has_fur {

    @Override
    public String noise() {
        return "SQUEAK";
    }  // really?

    @Override
    public String movement() {
        return "jump";
    }

    @Override
    public String fur_color() {
        return "beige";
    }
}

// concrete class 3
class Lizard implements animal {

    @Override
    public String noise() {
        return "Ssssss";
    }

    @Override
    public String movement() {
        return "crawl";
    }
}

// concrete class 4
class Snake implements animal{

    @Override
    public String noise() {
        return "Rattle";
    }

    @Override
    public String movement() {
        return "slither";
    }
}

abstract class animal_abstract_factory {
// this is for creating a factory without explicitly specifying the object classes.
// it has to be subclassed to return the real objects.
    public abstract animal get_animal(String animal_description);
}

// first factory
class mammal_factory extends animal_abstract_factory {
    @Override
    public animal get_animal(String animal_description) {
        switch (animal_description) {
            case "CAT"->{ return new Cat();}
            case "KANGAROO"->{ return new Kangaroo();}
            default->{
                System.out.println("`" + animal_description + "`: no such animal");
                return null;
            }
        }
    }
}

// second factory
class reptilian_factory extends animal_abstract_factory {
    @Override
    public animal get_animal(String animal_description) {
        switch (animal_description) {
            case "SNAKE"-> { return new Snake(); }
            case "LIZARD"->{ return new Lizard();}
            default-> {
                System.out.println("`" + animal_description + "`: no such animal");
                return null;
            }
        }
    }
}

// factory of factories
class animal_factory_producer {
    static animal_abstract_factory get_factory(String genus){
        if(genus.equals("REPTILIAN"))
            return new reptilian_factory();
        else if (genus.equals("MAMMAL"))
            return new mammal_factory();
        else {
            System.out.println("`" + genus + "`: no such genus");
            return null;
        }
    }
}



