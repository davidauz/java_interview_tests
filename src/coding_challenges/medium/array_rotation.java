package coding_challenges.medium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;


public class array_rotation {
    /*
A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2]
. Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
Given an array a of n integers and a number d, perform d left rotations on the array.
Return the updated array to be printed as a single line of space-separated integers.

rotLeft has the following parameter(s):

    int a[n]: the array to rotate
    int d: the number of rotations

Returns

    int a'[n]: the rotated array

     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        Integer r[] = new Integer[a.size()];
        for(int i=a.size()-1; i>=0; i--) {
            r[d++]= a.get(i);
            if(d==a.size())
                d=0;
        }
        return new ArrayList<>(List.of(r));
    }

    public void go() {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int d = 5;

        List<Integer> a = new ArrayList<>( List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) );
        List<Integer> result = rotLeft(a, d);

        try {
            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n"
            );
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
