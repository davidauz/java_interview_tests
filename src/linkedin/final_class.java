package linkedin;

public class final_class {
    final int some_final_int = 90;
    final void some_final_method(){
        System.out.println("I am a final method");
    }
    public void go() {
//        some_final_int=91; // compiler: cannot assign
        some_final_method();
    }
}

final class anotherFinalTest extends final_class {
//    public void some_final_method(){} // compiler: cannot override
}

/*
class extending_final_class extends linkedin.anotherFinalTest { // compiler: cannot inherit
    public void a_method(){
        System.out.println("something");
    }
}
*/