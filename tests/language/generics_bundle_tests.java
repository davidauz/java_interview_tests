package language;

import language.boundedWildcardType.*;
import language.generics.data_audio;
import language.generics.data_basic;
import language.generics.data_text;
import language.generics.generics_bundle;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class generics_bundle_tests {
	@Test
	public void test_generics(){
		generics_bundle<data_basic> gb = new generics_bundle<>();
		gb.add_element(new data_text("I will now play an audio file"));
		gb.add_element(new data_audio(Paths.get("/tmp/audio.mp3")));
		gb.add_element(new data_text("That was a nice song."));
		gb.show();
	}
	
	@Test
	public void test_bounded_wildcard_type (){
		Vegetable [] veggies=
		{	new Vegetable("Carrot")
		,	new Vegetable("Cucumber")
		,	new Vegetable("Tomato")
		};
		Vegetarian vegetarian = new Vegetarian("Victor");
		ArrayList<Vegetable> salad = new ArrayList(Arrays.asList(veggies));
		vegetarian.eats(salad);

		Meat [] meats=
		{	new Meat("Veal")
		,	new Meat("Chicken")
		,	new Meat("Pork")
		};
		Carnivore carnivore = new Carnivore("Carl");
		ArrayList<Meat> grill=new ArrayList<>(Arrays.asList(meats));
		carnivore.eats(grill);

		Omnivore omnivore = new Omnivore("Orson");
		ArrayList<Food> allFoods=new ArrayList<>(Arrays.asList(veggies));
		allFoods.addAll(Arrays.asList(meats));
		omnivore.eats(allFoods);
	}
}
