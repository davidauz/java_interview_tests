package language;

import org.junit.jupiter.api.Test;

class pass_value_reference_test {
	@Test
	public void test_pvr() {
		some_object co1 = new some_object(); // actually co1 is a pointer to a some_object
//or so it would be called in other languages
		System.out.println("co1 default values: "+co1.toString());
		some_object co2=co1; //co2 is nothing but a pointer to co1
		System.out.println("co2 points to co1: "+co2.toString());
		co1.string_field="Modified string value";
		co1.int_field=5;
		co1.long_field=10;
		System.out.println("co1 values were modified: "+co1.toString());
		System.out.println("so co2 values are modified too: "+co2.toString());
		System.out.println("Passing co2 in a function that modifies it");
		modify_object(co2);
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

	private void modify_object(some_object co) {
		co.string_field="MODIFICATION";
		co.int_field=0;
		co.long_field=0;
	}

}