package language;

import java.nio.charset.Charset;
import java.util.Random;

//This dumb class is used only to illustrate the passing by
//value or passing by reference in the relative test
public class example_pojo {
	static Random rand = new Random();
	public int int_field;
	public String string_field;
	public long long_field;

	public example_pojo(){
		int_field=rand.nextInt(100);
		string_field=rand.ints(48, 123)
		.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		.limit(20) // length
		.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		.toString();
		long_field=rand.nextLong(100);
	}

	public String toString(){
		return "int=`"+int_field+"`;"
		+" string=`"+string_field+"`;"
		+" long=`"+long_field+"`"
		;
	}
}
