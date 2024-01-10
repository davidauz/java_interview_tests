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

    }
