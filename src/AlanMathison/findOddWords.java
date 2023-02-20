package AlanMathison;

import java.util.*;

public class findOddWords {
/*
Given two string sets set2 and set2, finds all the Odd Words.
A word is called Odd when it appears only once in one of the sets, and does not appear in the other set.
Example input: "bag_of_nuts community is the best", "bag_of_nuts community is the gratest", "".
Output: ["best", "greatest"].
Constraints: 1<=set1.length, set2.length <=200
set1 and set2 contains lowercase letters and spaces
set1 and set2 have no leading or trailing spaces
set1 and set2 contain words separated by a simhle space

*/
    public void go() {
        System.out.println ( findOddWords("bag_of_nuts community is the best", "bag_of_nuts community is the gratest") );
    }


    public static List<String> findOddWords(String set1, String set2) {
        String[] words1 = set1.split("\\s+");
        String[] words2 = set2.split("\\s+");

        Set<String> set1Words = new HashSet<>(Arrays.asList(words1));
        Set<String> set2Words = new HashSet<>(Arrays.asList(words2));

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words1)
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);

        for (String word : words2)
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);

        // Find the odd words that only appear once and in one set only
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() == 1) {
                String word = entry.getKey();
                if ((set1Words.contains(word) && !set2Words.contains(word))
                        || (set2Words.contains(word) && !set1Words.contains(word))) {
                    oddWords.add(word);
                }
            }
        }

        return oddWords;
    }

}
