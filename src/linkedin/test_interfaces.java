package linkedin;

interface Interface1 {
    static void print() {
        System.out.print("Hello");
    }
    default void interface_method() {
        System.out.println("Interface1");
    }
}
interface Interface2 {
    static void print() {
        System.out.print("World!");
    }
    default void interface_method() {
        System.out.println("Interface2");
    }
}

class Three implements Interface1, Interface2 {
    public void interface_method() {
//        super.Interface2.method(); // cannot resolve symbol
//        Interface2.method(); // non static method
        Interface2.super.interface_method(); // ci vuole il super per distinguere quale dei due method
    }
}


public class test_interfaces {
    public void go(){
        Interface1.print();
        Interface2.print();
    }
}
