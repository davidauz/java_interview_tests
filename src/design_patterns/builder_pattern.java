package design_patterns;

//separate the construction of an object from its representation
public class builder_pattern {
	private int floors
	,	construction_year
	;
	private String address;
	private boolean is_residential
	,	is_industrial
	,	is_public
	,	is_private
	;

	public builder_pattern(building_builder bb) {
		construction_year=bb.construction_year;
		floors=bb.floors;
		address=bb.address;
		is_residential=bb.is_residential;
		is_industrial=bb.is_industrial;
		is_public=bb.is_public;
		is_private=bb.is_private;
	}

	public String toString(){
		return "Building\n"+
		(0!=floors?"has "+floors+" floors\n":"") +
		(0!=construction_year?"was built in year "+construction_year+"\n":"") +
		(0!=address.length()?"address is "+address+"\n":"") +
		"residential: "+is_residential+"\n" +
		"industrial: "+is_industrial+"\n" +
		"public: "+is_public+"\n"+
		"private: "+is_private+"\n"
		;
	}

	public static class building_builder
	{
		private int floors=0
		,	construction_year=0
		,	zip_code=0
		;
		private String address="";
		private boolean is_residential=false
		,	is_industrial=false
		,	is_public=false
		,	is_private=false
		;

		public building_builder(){}
		public building_builder floors(int floo){
			floors=floo;
			return this;
		}
		public building_builder address(String addr){
			address=addr;
			return this;
		}

		public building_builder zip(int zp) {
			zip_code=zp;
			return this;
		}


		public builder_pattern build(){
			builder_pattern building_instance=new builder_pattern(this);
			return building_instance;
		}

	}
}
