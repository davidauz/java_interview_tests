package assortedRecruiters;

public class TypingTime {
    public static int calculateTypingTime(String digits, String number) {
        int time = 0;
        int current = 0;
        for (char c : number.toCharArray()) {
            int next = digits.indexOf(c);
            time += Math.abs(next - current);
            current = next;
        }
        return time;
    }

    public void go() {
/*
A digit-only keyboard contains all 10 digits from 0 to 9.
They all exist in one line.
A string of 10 digits illustrating how the keys are positioned is given.
To type a digit you start from index zero to the index of the target digit.
It takes |a-b| milliseconds to move from index a to index b.
Write a java function to calculate the number of milliseconds needed to type a number.
Example 1: input digits="0123456789", number="210", output: "4".
Example 2: input digits="8459761203", number="5439", output: 17
*/
        System.out.println( calculateTypingTime("0123456789","210") );
        System.out.println( calculateTypingTime("8459761203","5439") );
    }
}
