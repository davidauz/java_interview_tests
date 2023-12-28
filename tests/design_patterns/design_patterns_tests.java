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
}