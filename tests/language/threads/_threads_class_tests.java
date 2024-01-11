package language.threads;

import org.junit.jupiter.api.Test;

class _threads_class_tests {
	@Test
	public void test_virtual_threads(){
		new threads_class().demonstrate_virtual_threads();
	}

	@Test
	public void test_platform_threads(){
		new threads_class().demonstrate_platform_threads();
	}

}