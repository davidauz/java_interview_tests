package language.boundedWildcardType;

public class Vegetarian extends Person<Vegetable> {
	public Vegetarian(String name) {super(name);}

	public String showEatsOnly(){return "vegetables";};
}
