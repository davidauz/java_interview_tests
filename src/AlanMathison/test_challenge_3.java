package AlanMathison;

import java.util.ArrayList;
import java.util.List;

public class test_challenge_3 {
/*
In a string k of lowercase letters, the letters can be repeated and exist consecutively.
a substring from k is considered valid if it contains at least three consecutive identical letters.
Here is an example: k="abcdddeeeeaabbbcd" has three valid strings: "ddd", "eeee", "bbb".
You can identify the substring by a pair of indeces : [first letter, last letter ].
Write a java program that returns the indices of the valid substrings of a given string k.
Must order the pairs by the start index in ascending order.
*/
    public ArrayList<ArrayList<Integer>> solution(String k) {
        // write your solution here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = k.length();

        for (int i = 0; i < n - 2; i++) {
            int j = i + 2;
            while (j < n && k.charAt(j) == k.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                String str=k.substring(i,j);
                result.add(new ArrayList<Integer>(List.of(new Integer[]{i, j - 1})));
                i=j-1;
            }
        }
        return result;
    }

    public void go(String a) {
        ArrayList<ArrayList<Integer>> arr=solution("abcdddeeeeaabbbcd");
        System.out.println(arr);
    }
}
/*
Expected result for "abcdddeeeeaabbbcd": [[3, 5], [6, 9], [12, 14]]
 */