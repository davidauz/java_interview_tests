package language;

import org.junit.jupiter.api.Test;

import static language.modern_switch_expression.animal.*;
import static org.junit.jupiter.api.Assertions.*;

class modern_switch_expression_test {

	public void test_switch_expression(modern_switch_expression.animal ani){
		System.out.print("A "
		+ani.name()
		+" has "+modern_switch_expression.new_syntax_get_legs(ani)
		+" legs and always "
		);
		modern_switch_expression.print_movement(ani);
	}

	@Test
	public void test_animals(){
		test_switch_expression(CAT);
		test_switch_expression(SNAKE);
	}

}