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


}
