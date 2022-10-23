package linkedin;

import java.lang.reflect.Method;

class one_random_class{
    public int method_ONE(){return 1;}
    public int method_TWO(){return 2;}
}

public class test_reflection {
    public void go() {
        one_random_class ORC = new one_random_class();
        System.out.println( "Test REFLECTION" );
        System.out.println( "Class name: "+ORC.getClass().getSimpleName() );
        System.out.println( "Class methods: "+ORC.getClass().getDeclaredMethods().length );
        for(Method i:ORC.getClass().getDeclaredMethods())
            System.out.println("-"+i);
    }
}
