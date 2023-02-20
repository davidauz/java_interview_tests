package coding_challenges.hard;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
In an array the elements at indices i and j (where i<j) form an inversion if arr[i]>arr[j].
To correct an inversion, we can swap adjacent elements.
Given an arbitrary array, return the number of inversions needed to sort the array.

from https://www.hackerrank.com/challenges/ctci-merge-sort/problem

The "hard" part is optimizing the code for time.
The site says:

    public static long countInversions(List<Integer> arr) {
    // Write your code here
    }

so the first thing you do is to convert the List<Integer> to an array of integers and start from there.
Turns out that the conversion itself is a time bottleneck.

So one has to look hard at the specifications:

    Input Format
    The first line contains an integer, d, the number of datasets.

    Each of the next d pairs of lines is as follows:
    1. The first line contains an integer, n, the number of elements in arr.
    2.  The second line contains m space-separated integers, arr[i].

Then rewrite the main method given as a starting point, here is main_as_it_is_in_the_original_problem

The new main method will accept the same input but use it to build an array instead of a List, then call
method countInversions on it
*/


class Result  {
    public static long countInversions(List<Integer> arr) {
        return 0;
    }

}

    public class array_inversion {

        public static long countInversions(int [] arr) {
            // Write your code here
            int n = arr.length;
            // Base Case
            if (n <= 1)
                return 0;

            // Recursive Case
            int mid = n >> 1;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            long inversions = countInversions(left) + countInversions(right);

            int range = n - mid;
            int iLeft = 0;
            int iRight = 0;
            for (int i = 0; i < n; i++) {
                if (iLeft < mid
                        && (iRight >= range
                        || left[iLeft] <= right[iRight]
                )
                ) {
                    arr[i] = left[iLeft++];
                    inversions += iRight;
                } else if (iRight < range)
                    arr[i] = right[iRight++];

            }

            return inversions;
        }

        public static void main_as_it_is_in_the_original_problem(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                    long result = Result.countInversions(arr);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }


        public static void main(String[] args) {

            int position=0
            ,   num_sets = Integer.parseInt(args[position++])
            ,   num_integers_in_set
            ;
            String str;
            int[] target_array;
            try {
                for (int set = 0; set < num_sets; set++) {
                    num_integers_in_set = Integer.parseInt(args[position++]);
                    str = args[position++];
                    target_array = new int[num_integers_in_set];
                    Scanner scanner = new Scanner(str);
                    for (int curr_index = 0; curr_index < num_integers_in_set; curr_index++)
                        target_array[curr_index] = scanner.nextInt();

                    System.out.println(str+": "+countInversions(target_array));
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        public void go() {
            main(new String[] {"3",

                    "5", "1 1 1 2 2",

                    "5", "2 1 3 1 2",

                    "224", "1438 5804 8058 8257 5369 7186 7192 8924 1402 9129 2871 2261 5790 " +
                    "1773 2442 9418 7037 8537 5674 6322 4378 1560 1752 6244 3080 5455 6562 617 6537 8630 7166 4867 9423 6657 7361 9826 5275 3431 " +
                    "5069 4512 9391 7693 5357 8350 9446 7320 5947 4412 4412 2810 9918 2983 4069 4087 3139 7311 4750 1917 9797 310 1167 1473 4554 " +
                    "3046 8726 7476 4577 811 1743 3706 4359 5554 9837 1134 8574 8540 3116 4052 865 1133 5632 5839 5961 7546 4158 8439 4922 9565 " +
                    "1979 1697 3708 2651 4983 8308 1674 1873 4460 4221 1594 6397 5574 2992 2783 1272 642 3530 2211 8302 8044 3648 1844 2688 7923 " +
                    "3382 3307 2373 837 4155 417 1194 2973 48 3063 39 4829 4336 239 4161 1750 2328 7082 88 5797 4253 5846 8492 38 7229 1547 62 " +
                    "3893 4071 932 9337 6933 3030 3011 2397 526 1114 9298 4635 1231 4985 8084 5479 1460 411 4534 2595 9564 954 809 6155 4393 7696 " +
                    "1388 2081 2428 1500 6697 3896 893 5982 3649 4429 6495 2880 4780 6328 4604 3148 6464 9327 9224 6735 5475 2458 5590 7024 8605 " +
                    "2785 88 1206 5077 3573 7833 2869 3755 1817 8762 4959 9593 2137 3955 3122 5347 9769 175 8825 9961 6966 5781 1115 4186 2142 1958 " +
                    "2559 240 7043 544 1378 4275 9179"
            } );
        }
    }
