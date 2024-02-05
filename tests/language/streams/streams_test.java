package language.streams;

import language.example_pojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class streams_test {
	@Test
	void foreach_test(){
		final int array_size=12;
		example_pojo pojos[]=new example_pojo[array_size];
		for(int i=0; i<array_size; i++)
			pojos[i]=new example_pojo();

		System.out.println(pojos[3].toString());
		test_streams.test_foreach(pojos);
		System.out.println(pojos[3].toString());
	}

}