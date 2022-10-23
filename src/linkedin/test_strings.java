package linkedin;

public class test_strings {
    public static void test_arguments(String[] args){
        System.out.println("args is "+args+", args[2] is `"+args[2]+"`");
    }

    public static void test_substring(String s, int b, int e){
        System.out.println("String s is `"+s+"`, s.substring("+b+", "+e+") is `"+s.substring(b, e)+"`");
    }


    private void operators_do_not_return_values() {
        String str = "abcde";
        System.out.println("Beginning string operations on `"+str+"`");
        str.trim();
        str.toUpperCase();
        str.substring(3, 4);
        System.out.println("The original string `"+str+"` is unchanged");  // operators do not change the original string

        System.out.println("String operations on `"+str+"`:");
        str = "abcde";
        str=str.trim();
        str=str.toUpperCase();
        str=str.substring(3, 4);
        System.out.println("This time the string is `"+str+"`");
    }



    public void substrings_and_such()
        {
            test_substring("012345678", 3, 7);
            test_substring("012345678", 2, 5);

            System.out.println("TEST ARGUMENTS");
            test_arguments( new String[] { "1", "2", "3 4", "5" }); // inline initialization
            test_arguments( new String[] { "1", "2", "2", "5"});
            test_arguments( new String[] { "1", "2", "2", "5"});
            test_arguments( new String[] { "1", "2", "3 4", "5"});
        }


    public void go() {
        operators_do_not_return_values();
        substrings_and_such();
    }

}