package language;

public class modern_switch_expression {

	enum animal
	{	DUCK
	,	CHICKEN
	,	DOG
	,	CAT
	,	SNAKE
	,	HOUSEFLY
	,	BUTTERFLY
	};

	public static int old_syntax_get_legs(animal ani){
		int legs=-1;
		switch(ani){
			case DUCK:
			case CHICKEN:
				legs=2;
				break;
			case DOG:
			case CAT:
				legs=4;
				break;
			case SNAKE:
				legs=0;
				break;
			case HOUSEFLY:
			case BUTTERFLY:
				legs=6;
				break;
			default: // has to be last
				throw new IllegalStateException("Unexpected value");
		}
		return legs;
	}

	public static int new_syntax_get_legs(animal ani){
		int legs=switch(ani){
			case DUCK, CHICKEN->2;
			case DOG, CAT->4;
			default->throw new IllegalStateException("Unexpected value"); // no fall-through
			case SNAKE->0;
			case HOUSEFLY, BUTTERFLY->6;
		};
		return legs;
	}

	public static void print_movement(animal ani){
		switch(ani){
			case DUCK,CHICKEN,DOG,CAT ->{System.out.println("run");}
			case SNAKE ->{System.out.println("slither");}
			case HOUSEFLY,BUTTERFLY ->{System.out.println("fly");}
		}
	}
}
