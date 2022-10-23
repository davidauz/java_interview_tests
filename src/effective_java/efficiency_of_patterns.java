package effective_java;

import java.util.regex.Pattern;

import static java.lang.System.currentTimeMillis;

public class efficiency_of_patterns {
    class pattern_efficiency {
        static String finished_product_regex = "[0-1][A-Z][A-Z][A-Z][A-Z][A-Z][A-Z]A[0-9A-Z][0-9A-Z]*";
        static String part_regex = "[A-Z][0-9A-Z][0-9A-Z]*";
        static String fp_code = "1AACCHIA02900";
        static String p_code = "DRW0987HCX7";
        private static final Pattern p_fp = Pattern.compile(finished_product_regex);
        private static final Pattern p_pp = Pattern.compile(part_regex);

        private static void try_pattern(String s, String s1) {
            System.out.println("`" + s + "` and `" + s1 + "` gives`" + Pattern.matches(s, s1) + "`");
        }

        public static void test_patterns() {
            long l = currentTimeMillis();

            try_pattern(finished_product_regex, fp_code);
            try_pattern(finished_product_regex, p_code);
            try_pattern(part_regex, p_code);
            try_pattern(part_regex, fp_code);

            System.out.println("Running tests NO COMPILE");
            test_no_compile(1000);
            System.out.println("Time elapsed: "+(currentTimeMillis()-l));

            System.out.println("Running tests YES COMPILE");
            l = currentTimeMillis();
            test_si_compile(1000);
            System.out.println("Time elapsed: "+(currentTimeMillis()-l));
        }

        private static void test_si_compile(int i) {
            for(int n=0; n<i; n++){
                p_fp.matcher(fp_code).matches( );
                p_fp.matcher(p_code).matches( );
                p_pp.matcher(fp_code).matches( );
                p_pp.matcher(p_code).matches( );
            }
        }

        private static void test_no_compile(int i) {
            for(int n=0; n<i; n++){
                Pattern.matches(finished_product_regex, fp_code);
                Pattern.matches(finished_product_regex, p_code);
                Pattern.matches(part_regex, p_code);
                Pattern.matches(part_regex, fp_code);
            }
        }
    }

    public void go() {
        pattern_efficiency.test_patterns();
    }

}
