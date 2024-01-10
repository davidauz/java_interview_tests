package coding_challenges.hard;

public class longest_common_sequence {
/*
Given two strings, write a method that finds the longest common sub-sequence.
*/
    public static String find__longest_common_seq(String s1, String s2) {
        String  sample
        ,        result="";
        for(int start=0; start<s1.length();start++)
            for(int end=start+1;end<s1.length();end++) {
                sample = s1.substring(start, end);
                if(s2.contains(sample) && result.length()<sample.length())
                    result=sample;
            }
        return result;
    }
}
