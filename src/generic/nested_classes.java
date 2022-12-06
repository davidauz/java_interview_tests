package generic;

public class nested_classes {

    public interface anonymous_class{ // technically this is a nonstatic member interface?
        void speak();
    }

    public static class static_member_class{ // static member class
        public static void speak(){System.out.println("I am a Static Member Class");}
    }

    public class non_static_member_class{
        public static void speak(){System.out.println("I am a NON Static Member Class");}
    }

    public void go(){
        class local_class {
            static void speak(){System.out.println("I am a local nested class");}
        }

        System.out.println("There are four types of nested class: \n" +
                        "#Static member classes \n" +
                        "#Nonstatic member classes\n" +
                        "#Anonymous classes\n" +
                        "#Local classes\n");
        static_member_class.speak();
        non_static_member_class.speak();
        local_class.speak();
        new anonymous_class() {
            @Override
            public void speak() {
                System.out.println("I am an Anonymous Class");
            }
        }.speak();
    }
}
