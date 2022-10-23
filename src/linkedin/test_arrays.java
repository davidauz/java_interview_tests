package linkedin;

public class test_arrays {
    public void go() {
            int array[] = {1, 2, 3, 4};
            for (int i = 0; i < array.length /* not .size() as in many trick questions */; i++) {
                System.out.print(array[i]); // 1234
            }
    }
}
