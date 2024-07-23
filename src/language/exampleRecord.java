package language;


//A Record is an immutable data class that requires only the type and name of fields:
public record exampleRecord
(	double width
,	double height
,	double depth
,	double weight
) {
	public double get_volume(){
		return width*height*depth;
	}

	public double get_density(){
		double vol=get_volume();
		assert(vol>0);
		return weight/get_volume();
	}

// custom constructor
	public exampleRecord(double volume){
		this(0, 0, 0, volume);
	}

//	public void setWidth(double i) {
//		width=i;  cannot modify, it is final by default
//	}
}
