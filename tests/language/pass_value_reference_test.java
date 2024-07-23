package language;

import org.junit.jupiter.api.Test;

class pass_value_reference_test {

	@Test
	public void test_pvr() {
		example_pojo co1 = new example_pojo(); // actually co1 is a pointer to a example_pojo
//or so it would be called in other languages
		System.out.println("co1 default values: "+co1.toString());
		example_pojo co2=co1; //co2 is nothing but a pointer to co1
		System.out.println("co2 points to co1: "+co2.toString());
		co1.string_field="Modifying values in co1";
		co1.int_field=5;
		co1.long_field=10;
		System.out.println("co1 values were modified: "+co1.toString());
		System.out.println("co2 values are modified too: "+co2.toString());
		System.out.println("Passing co2 to a function that modifies it");
		modify_object(co2); // this is called "passing argument as value"
// and it is a bit tricky: actually the reference (address) to the object is passed by value.
// instead, passing as "reference" is when using pointers in other languages
		System.out.println("co1 is modified too: "+co1.toString());
		System.out.println("Dereferencing co1");
		co1=null;// co1 is dereferenced
		try {
			System.out.println("co1 raises exception: " + co1.toString());
		}catch (Exception e){
			System.out.println("Calling co1.toString() after dereferencing raises exception as expected");
		}
		System.out.println("But co2 is still with us: "+co2.toString());
		System.out.println("Dereferencing co2");
		co2=null;
		try {
			System.out.println("co2 raises exception: " + co2.toString());
		}catch (Exception e){
			System.out.println("Calling co2.toString() after dereferencing raises exception too.");
		}
		System.out.println("Now there are no longer pointers to co1 or co2, the garbage collector frees the memory.");
	}

	@Test
	public void test_modify_primitive(){
		int x=10;
		System.out.println("Before: integer variable is "+x);
		modify_int(x);
		System.out.println("After: integer variable is "+x); // still 10
// because it was passed "by value"
	}

	private void modify_int(int x) {
		x=0;
	}

	private void modify_object(example_pojo co) {
		System.out.println("Modifying fields");
		co.string_field="MODIFICATION";
		co.int_field=0;
		co.long_field=0;
	}

}