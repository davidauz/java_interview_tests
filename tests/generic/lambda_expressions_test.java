package generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class lambda_expressions_test {
	@Test
	public void test_lambda_expressions(){
// some data
		Animal Felix = new Cat("Felix")
		, Rio=new Ostrich("Rio")
		, Nemo=new Fish("Nemo")
		, Tom = new Cat("Tom")
		;
// populate list
		List<Animal> list_animals = new ArrayList<>(List.of(Felix, Rio, Nemo, Tom));

//------------------------------ level 1 ----------------------------
// look for animals with 2 paws using a simple loop on the list
		List<Animal> result_list=lambda_expressions.look_for_paws(list_animals,2);
		show_results("Normal loop", result_list);

// now what if I want to look for animals with 2 paws and feathers?  Or animals with 2 paws called "Rio"?
// I'd have to write many methods similar to look_for_paws.



//------------------------------ level 2 ----------------------------
// Or, I could implement a functional interface and then pass a class with the needed tests inside
		result_list= lambda_expressions.look_with_tester_class(list_animals, new test_animal_criteria());
		show_results("Tester class", result_list);



//------------------------------ level 3 ----------------------------
// Or, I could use an anonymous class, so I have my criteria always under my eye:
		result_list= lambda_expressions.look_with_tester_class(list_animals, new animal_tester() {
			public boolean test(Animal a) {
				return a.paws==2 && a.get_name().equals("Rio");
			}
		});
		show_results("Anonymous function", result_list);




//------------------------------ level 4 ----------------------------
// Or I could use a (drumroll) LAMBDA FUNCTION!
		result_list= lambda_expressions.look_with_tester_class(list_animals
				,   (Animal a) -> a.get_name().equals("Rio") && 2==a.paws
		);
		show_results("Lambda expression", result_list);



	}



	private void show_results(String prompt, List<Animal> result_list) {
		for (Animal animal:result_list)
			System.out.println( prompt+": "+animal.getClass()+" `"+animal.get_name()+"` has `"+animal.paws+"` paws.");
	}
}
