package constructs.boundedWildcardType;

import java.util.Collection;
import java.util.List;

public abstract class Person<T extends Food> {
	public String name;

	public Person(String name) { this.name = name;}

	public abstract String showEatsOnly();


// Bounded wildcard type to enforce specific food types
	public void eats(List<? extends T> foodList) {
		System.out.print(name + " eats "+showEatsOnly()+":");
		for (Food food : foodList) {
			System.out.print(food + ", ");
		}
		System.out.println();
	}
}
