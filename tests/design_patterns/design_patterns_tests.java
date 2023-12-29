package design_patterns;

import org.junit.jupiter.api.Test;

class design_patterns_tests {
	@Test
	public void test_builder(){
		building bldg=
		new building.building_builder()
		.floors(2)
		.address("Main street 5")
		.zip(20111)
		.build()
		;
		System.out.println(bldg.toString());
	}

	@Test
	public void test_abstract_factory() {
		String animal_descr="CAT";
		animal a;
		animal_abstract_factory mammals_factory = animal_factory_producer.get_factory("MAMMAL");
		animal_abstract_factory reptilian_factory = animal_factory_producer.get_factory("REPTILIAN");

		a = mammals_factory.get_animal(animal_descr);
		System.out.println("I am a `"+animal_descr+"` and I go `"+a.noise()+"`");

		animal_descr="KANGAROO";
		a = mammals_factory.get_animal(animal_descr);
		System.out.println("I am a `"+animal_descr+"` and I go `"+a.noise()+"`");

		animal_descr="SNAKE";
		a = reptilian_factory.get_animal(animal_descr);
		System.out.println("I am a `"+animal_descr+"` and I go `"+a.noise()+"`");

		animal_descr="LIZARD";
		a = reptilian_factory.get_animal(animal_descr);
		System.out.println("I am a `"+animal_descr+"` and I go `"+a.noise()+"`");
	}

	@Test
	public void test_singleton() {
		System.out.println("Singleton has been called "+singleton_object.getInstance().get_times_called()+" times.");
		System.out.println("Singleton has been called "+singleton_object.getInstance().get_times_called()+" times.");
		System.out.println("Singleton has been called "+singleton_object.getInstance().get_times_called()+" times.");
	}
}