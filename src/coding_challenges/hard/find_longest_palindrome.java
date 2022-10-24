package coding_challenges.hard;

public class find_longest_palindrome {

    private String findLongestPalindrome(String word) {
        int j=-1
                ,   t_end=0
                ,   t_start=0
                ,   max_length=0
                ;
        for(int i=1; i<word.length();i++) {
            if(-1!=j){
                if(j>=0)
                    if(j>0 && word.charAt(j-1)==word.charAt(i)){
                        j=j-1;
                        if(max_length<(i-1-j)) {
                            t_start = j;
                            t_end = i;
                            max_length=t_end-t_start;
                        }
                    } else{
                        if(max_length<(i-1-j)) {
                            t_start = j;
                            t_end = i;
                            max_length=t_end-t_start;
                        }
                        j=-1;
                    }
            } else {
                if (word.charAt(i - 1) == word.charAt(i))
                    j = i - 1;
                if (i > 1 && word.charAt(i - 2) == word.charAt(i))
                    j = i - 2;
            }
        }
        if(0==max_length)
            return String.valueOf(word.charAt(0));
        else
            return word.substring(t_start, t_end);
    }
    public void go() {
        System.out.println(findLongestPalindrome("abcba"));
        System.out.println(findLongestPalindrome("abattd"));
        System.out.println(findLongestPalindrome("abc"));
        System.out.println(findLongestPalindrome("thhwerw"));
        System.out.println(findLongestPalindrome("perttremapcmpaimcpaimscpiamscpoiutuiop55333OKMIJNUHBYGVGYBHUNJIMKO33355sabcuyavgscuyvascqwertyuiopoiuytrewqnviuernviuernvijnuhbbhunji"));
    }
}
