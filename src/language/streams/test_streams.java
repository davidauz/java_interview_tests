package language.streams;

import language.example_pojo;

import java.util.stream.Stream;

public class test_streams {
	public static void test_foreach(example_pojo[] pojos){
		int num=1;
		Stream.of(pojos).forEach(e -> e.int_field=0);
	}
}
