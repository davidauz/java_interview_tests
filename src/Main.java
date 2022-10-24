//import coding_challenges.*;
//import coding_challenges.hard.*;
import coding_challenges.medium.*;
import effective_java.*;
import linkedin.*;
import turing.*;

public class Main {

    private static void effective_java() {
//  from the awesome book "Effective Java"
        new efficiency_of_patterns().go();
    }


    private static void coding_interview_planner() {
// These are from https://code-exercises.com/coding-interview-planner/
// Hard
//        new is_perfect_tree().go();
//        new find_longest_palindrome().go();
// Medium
        new even_fibonacci_sum().go();
    }

    private static void turing_tests() {
//      The following are taken from the Turing tests https://developers.turing.com/
        new turing_test_1().go(new String[] {"5", "2", "C", "D", "+"});
        new turing_test_2().go("()[]{}");
        new turing_test_3().go("5 7 3 9 4 9 8 3 1,1 2 2 4 4 1,1 2 3");
    }

    private static void linkedin_tests() {
//      The following are taken from the Linkedin assessment tests
        new final_class().go();
        new float_precision().go();
        new test_arrays().go();
        new test_constructors().go();
        new test_dates().go();
        new test_exceptions().go();
        new test_interfaces().go();
        new test_iterators().go();
        new test_operators().go();
        new test_polymorhpism_overriding().go();
        new test_reflection().go();
        new linkedin.test_strings().go();
    }


    public static void main(String[] args) {
//        linkedin_tests();
//        turing_tests();
        coding_interview_planner();
//        effective_java();
    }
}
