package language.boundedWildcardType;

public class Omnivore extends Person<Food> {
	public Omnivore(String name) {super(name);}

	public String showEatsOnly(){return "anything";};
}
