package design_patterns;

/*
A proxy object is useful when a heavy operation is to be avoided until the last possible moment.
Here a ship is allowed to leave port only when it is fully loaded.
*/

interface vessel{
	final static int total_tonnage=10;
	public void ship(int item_tonnage);
}


class real_vessel implements vessel{

	public void ship(int tonnage){
		System.out.println("Now shipping "+tonnage+" tons.");
	}
}


class proxy_vessel implements vessel{
	private real_vessel realvessel=new real_vessel();
	private int loaded_tonnage=0;
	public void ship(int item_tonnage){
		loaded_tonnage +=item_tonnage;

		if(loaded_tonnage>total_tonnage)
			realvessel.ship(loaded_tonnage);
		else
			System.out.println("Now the ship has "+loaded_tonnage+" tons; not shipping yet.");
	}
}

