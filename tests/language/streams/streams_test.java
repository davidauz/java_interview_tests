package language.streams;

import language.example_pojo;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class streams_test {

	public void test_foreach(example_pojo[] pojos){
		int num=1;
		Stream.of(pojos).forEach(e -> e.int_field=8888);
	}

	private void pojos_dump(String title,example_pojo[] pojos) {
		System.out.println(title);
		IntStream.range(0, pojos.length).forEach(idx->System.out.println(idx+":"+pojos[idx].toString()));
		System.out.println("");
	}

	private example_pojo[] get_array_of_random_pojos(int array_size) {
		example_pojo pojos[]=new example_pojo[array_size];
		for(int i=0; i<array_size; i++)
			pojos[i]=new example_pojo();
		return pojos;
	}



	@Test
	void test_foreach(){ // terminal
//remember: when in a Collection always try using Collection.foreach
		final int array_size=12;
		example_pojo pojos[]=get_array_of_random_pojos(5);
		pojos_dump("Before",pojos);
		test_foreach(pojos);
		pojos_dump("After", pojos);
	}

	@Test
	void test_map(){ // map() is an intermediate operation.
//transforms the elements of a collection based on a specified function.
//It returns a new Stream as return value.
//i.e. takes a function as an input and returns a stream consisting of the results of applying
//	the supplied function to each element of the stream
// The new stream could be of different type
		example_pojo pojos[]=get_array_of_random_pojos(10);
		pojos_dump("Before", pojos);
		Stream.of(pojos)
		.map(elem->{elem.string_field="Acceptable";return elem;})
		.collect(Collectors.toList())
		.stream()
		.filter(el->el.int_field<40)
		.map(elem->{elem.string_field="Small";return elem;})
		.collect(Collectors.toList())
		.stream()
		.filter(el->el.int_field<20)
		.map(el->{el.string_field="Very small";return el;})
		.collect(Collectors.toList())
		;
		pojos_dump("After", pojos);
	}

}