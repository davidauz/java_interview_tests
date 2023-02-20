package linkedin;

public class test_exceptions {

    static Exception print(int i){
        if (i>0) {
            return new Exception();
        } else {
            throw new RuntimeException();
        }
    }

    public static void test_badMethod(String[] args) {
    try {
        System.out.println("A");
        badMethod();
        System.out.println("B");
    } catch (Exception ex) {
        System.out.println("C");
    } finally {
        System.out.println("D");
    }
    }


    public static void badMethod() {
        throw new Error();
    }


    public void go (){
        System.out.println(print(1));
        try { // expected output is "A", "D": Error is not inherited from Exception
            test_badMethod(new String[]{"a"});
        }catch(Error e){
            System.out.println("Error detected");
        }
    }
}
