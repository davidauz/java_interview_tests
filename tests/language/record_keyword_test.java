package language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class record_keyword_test {
	public String show_object(record_keyword_example rke){
		return String.format
		(	"has volume=%f, density=%f\nits dimension are:%fx%fx%f\nand its weight is %f"
		,	rke.get_volume() // can call its members
		,	rke.get_density()
		,	rke.depth() // getters for free
		,	rke.height()
		,	rke.width()
		,	rke.weight()
		);
	}
	@Test
	public void test_record_keyword(){
// constructor is generated with all the needed fields
		record_keyword_example rke = new record_keyword_example(2.1, 3.2, 4.3, 5.4)
		,	another_rke=new record_keyword_example(2, 3, 4, 5)
		,	custom_constructor_rke=new record_keyword_example(12);
		;
		System.out.println("First object "+show_object(rke));
		System.out.println("Second object "+show_object(another_rke));
//		rke.setWidth(5); cannot modify: it is final by default

//.equals is generated
		System.out.println("The two objects are "+(rke.equals(another_rke)?"":"NOT")+" equal");
		System.out.println("Hashcode is "+rke.hashCode());
		System.out.println("toString is "+rke.toString());

//try the custom constructor
		System.out.println("toString is "+custom_constructor_rke.toString());
	}

}