package assortedRecruiters;

import java.util.*;

class Solution {

    public static List<String> generateParenthesis(int n) {
        if(n==1)
            return new ArrayList<String>(Arrays.asList("()"));
        Set<String> set=new HashSet<String>();
        for(String str:generateParenthesis(n-1)){
            for(int i=0;i<str.length();i++){
                set.add(str.substring(0,i+1)+"()"+str.substring(i+1,str.length()));
            }
        }
        List<String> list = new ArrayList<String>(set);
        return list;
    }

    /**
     * also here: https://leetcode.com/problems/generate-parentheses/
     */
}
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

 */

public class test_challenge_2 {
    public void go(int i) {
        List<String> output = Solution.generateParenthesis(i);
        Collections.sort(output);
        String result = "\"" + String.join("\", \"", output) + "\"";
        result = result.replaceAll("\\s+","");
        System.out.println("[" + result + "]");
    }
}
