package AlanMathison;

import java.util.*;

public class test_practice_1 {
    class Solution {
        public static int solution(int[][] cards) {
            // write your solution here
            int res = -1, winning = -1, freq, max;
            ArrayList<Integer> ints;
            for (int i = 0; i < cards.length; i++) {
                int[] arr_hand = cards[i];
                ints = new ArrayList<>();
                for (int j = 0; j < arr_hand.length; j++)
                    ints.add(arr_hand[j]);
                do {
                    max = (int) Collections.max(ints);
                    freq = Collections.frequency(ints, max);
                    if (1 == freq) {
                        winning = max;
                        break;
                    }
                    int finalMax = max;
                    ints.removeIf(s -> s.equals(finalMax));
                    if (0 == ints.size()) {
                        winning = -1;
                        break;
                    }
                } while (1 < freq);
                ints.clear();
                if (winning > res)
                    res = winning;
            }
            return res;
        }
    }
    public void go(String arg)
    {
        Scanner sc = new Scanner(arg);

        String[] components = sc.nextLine().split(",");
        List<int[]> myList = new ArrayList<int[]>();

        int size = components.length;
        int[][] mtx = new int[1][size];
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
            String[] numbersStr = components[i].split(" ");
            int[] numbers = new int[numbersStr.length];
            for(int j=0; j<numbersStr.length; j++)
            {
                numbers[j] = Integer.parseInt(numbersStr[j]);
            }
            myList.add(numbers);
        }

        mtx = myList.toArray(mtx);
        System.out.println(Solution.solution(mtx));
    }
}
