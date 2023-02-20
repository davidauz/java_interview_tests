package linkedin;

class Jedi {
    /* Constructor A */
    private String m_name
    ,   m_species
    ;
    private boolean is_dark;
    Jedi(String name, String species){
        this(name, species, false);
        System.out.println("A");
    }

    /* Constructor B */
    Jedi(String name, String species, boolean followsTheDarkSide){
            System.out.println("B");
            m_name=name;
            m_species=species;
            is_dark=followsTheDarkSide;
    }

    public void print() {
        System.out.println("I am `"+m_name+"` of `"+m_species+"`, "+(is_dark?"DARK":"REGULAR"));
    }
}

public class test_constructors {
    public void go() {
        Jedi luke = new Jedi( "Luke","human");
        luke.print();
    }
}
