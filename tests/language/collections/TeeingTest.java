package language.collections;

import org.junit.jupiter.api.Test;

class TeeingTest {
	@Test
	void testTeeming(){
		Teeing tee=new Teeing();
		tee.teeingStrings();
		tee.teeingIntegers();
	}
}