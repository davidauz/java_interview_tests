package generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class nested_classes_test {
	@Test
	public void go(){
		class local_class {
			static void speak(){System.out.println("I am a local nested class");}
		}

		System.out.println("There are four types of nested class: \n" +
				"#Static member classes \n" +
				"#Nonstatic member classes\n" +
				"#Anonymous classes\n" +
				"#Local classes\n");
		nested_classes.static_member_class.speak();
		nested_classes.non_static_member_class.speak();
		local_class.speak();

		new nested_classes.anonymous_class() {
			@Override
			public void speak() {
				System.out.println("I am an Anonymous Class");
			}
		}.speak();
	}

}