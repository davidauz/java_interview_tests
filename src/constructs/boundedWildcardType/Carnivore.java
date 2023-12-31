package constructs.boundedWildcardType;

public class Carnivore extends Person<Meat> {
	public Carnivore(String name) {
		super(name);
	}
	public String showEatsOnly(){return "meat";};
}
