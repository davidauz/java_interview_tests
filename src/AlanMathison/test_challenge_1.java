package AlanMathison;

import java.util.ArrayDeque;
import java.util.Deque;

public class test_challenge_1 {
    class Solution {
/**
* @param str: String to be tested for validity
* @return boolean: Returns true if the string is valid else false
*/
        public static boolean isValid(String s) {
            char ch, popped;
            Deque<Character> stack = new ArrayDeque<Character>();
            for(int i=0; i< s.length(); i++){
                ch=s.charAt(i);
                switch (ch){
                    case '(':
                    case '{':
                    case '[':
                        stack.push(ch);
                        break;
                    case ')':
                        popped=stack.pop();
                        if(popped!='(')
                            return false;
                        break;
                    case '}':
                        popped=stack.pop();
                        if(popped!='{')
                            return false;
                        break;
                    case  ']':
                        popped=stack.pop();
                        if(popped!='[')
                            return false;
                        break;
                }
            }
            return true;
        }
    }
    public void go(String s) {
        System.out.println(Solution.isValid(s));
    }
}
