package language;

//This dumb class is used only to illustrate the passing by
//value or passing by reference in the relative test
public class example_pojo {
	public int int_field;
	public String string_field;
	public long long_field;

	public example_pojo(){
		int_field=1;
		string_field="Default values";
		long_field=2L;
	}

	public String toString(){
		return "int=`"+int_field+"`;"
		+" string=`"+string_field+"`;"
		+" long=`"+long_field+"`"
		;
	}
}
