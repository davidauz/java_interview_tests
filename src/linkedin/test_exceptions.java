package linkedin;

public class test_exceptions {

    static Exception print(int i){
        if (i>0) {
            return new Exception();
        } else {
            throw new RuntimeException();
        }
    }

    public static void go (){
        System.out.println(print(1));
    }
}
