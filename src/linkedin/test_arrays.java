package linkedin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test_arrays {
    public void test_array_and_lists(String[] args){
            String[] array = {"abc", "2", "10", "0"};
            List<String> list = Arrays.asList(array);
            Collections.sort(list);
            System.out.println(Arrays.toString(array));
// Output is [0, 10, 2, abc]
// list is transparent to the array: sorting list also sorts the array
        }


    public void spot_array_length_size() {
        int array[] = {1, 2, 3, 4};
        for (int i = 0; i < array.length /* not .size() as in many trick questions */; i++) {
            System.out.println(array[i]); // 1234
        }
    }

    
    public void go() {
        spot_array_length_size();
        test_array_and_lists(new String[] {});
    }
}
