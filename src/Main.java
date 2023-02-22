import coding_challenges.hard.*;
import coding_challenges.medium.*;
import effective_java.*;
import generic.*;
import linkedin.*;
import assortedRecruiters.*;
import design_patterns.*;

public class Main {

    private static void generic_tests() {
//  random tests found on the internet
        new armstrong_number().go();
        new collections().go();
        new lambda_expressions().go();
        new nested_classes().go();
    }


    private static void effective_java() {
//  from the awesome book "Effective Java"
        new efficiency_of_patterns().go();
        try { new try_with_resources().go(); } catch(Exception e){}
        new weak_soft_phantom().go();
    }


    private static void coding_interview_planner() {
// These are from https://code-exercises.com/coding-interview-planner/
// Hard
        new is_perfect_tree().go();
        new find_longest_palindrome().go();
        new longest_common_sequence().go();
        new array_inversion().go();
// Medium
        new even_fibonacci_sum().go();
        new strict_binary_tree().go();
        new array_rotation().go();
    }

    private static void assorted_recruiters_tests() {
//      The following are taken from one random online recruiter
        new test_practice_1().go("5 7 3 9 4 9 8 3 1,1 2 2 4 4 1,1 2 3");
        new test_practice_2().go(new String[] {"5", "2", "C", "D", "+"});
        new test_challenge_1().go("()[]{}");
        new CardGame().go();
        new findOddWords().go();
        new test_challenge_2().go(3);
        new test_challenge_3().go("a");
        new TypingTime().go();
        new SpecialCard().go();
    }

    private static void linkedin_tests() {
//      The following are taken from the LinkedIn assessment tests
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
        new test_strings().go();
    }

    public static void main(String[] args) {
        linkedin_tests();
        assorted_recruiters_tests();
        coding_interview_planner();
        effective_java();
        generic_tests();
        new design_patterns().go();
    }
}
