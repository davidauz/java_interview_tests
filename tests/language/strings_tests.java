package language;

import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

public class strings_tests {
	@Test
	public void build_a_string() {
//two ways to build a string
		String str1 = "ABC"; // created in the String pool
		String str2 = new String("DEF"); // created in the heap
		System.out.println("1: "+str1+", 2: "+str2);
//let's talk performance
		performance_test_stringbuilder();
		performance_test_stringbuffer();
	}

	private void performance_test_stringbuilder() {
		System.out.println("Testing StringBuffer - slower; thread safe");
		System.gc();
		long start=new GregorianCalendar().getTimeInMillis();
		StringBuffer sb = new StringBuffer(); // slower; thread safe
		for(int i = 0; i<10000000; i++)
			sb.append(":").append(i);

		long end=new GregorianCalendar().getTimeInMillis();
		System.out.println("Time Taken:"+(end-start));

	}

	private void performance_test_stringbuffer() {
		System.out.println("Testing StringBuilder - faster; NOT thread safe");
		System.gc();
		long start=new GregorianCalendar().getTimeInMillis();
		StringBuilder sb = new StringBuilder(); // faster; NOT thread safe
		for(int i = 0; i<10000000; i++)
			sb.append(":").append(i);

		long end=new GregorianCalendar().getTimeInMillis();
		System.out.println("Time Taken:"+(end-start));
	}


}
