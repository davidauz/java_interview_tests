package effective_java;

import org.junit.jupiter.api.Test;

import static effective_java.efficiency_of_patterns.pattern_efficiency.*;

//  from the awesome book "Effective Java"

public class effective_java_tests {

	@Test
	public void test_efficiency() {
		test_patterns();
	}


	@Test
	public void test_weak_soft_phantom(){
		weak_soft_phantom wsp=new weak_soft_phantom();

		wsp.strong_reference();
		wsp.weak_reference();
		wsp.soft_reference();
		wsp.phantom_reference();
	}


	@Test
	public void test_try_with_resources() {
		try_with_resources twr=new try_with_resources();

        System.out.print("------- CASE 1 -------");
        twr.go_smooth();

        System.out.print("------- CASE 2 -------");
		twr.go_exception_1();

		System.out.print("------- CASE 3 -------");
		twr.go_exception_2();
		System.out.println("END");
	}
}
