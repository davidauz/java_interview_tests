package language;

public class var_keyword {
//	public var x=1;  no instance variables
//	static var no_static_vars;

	public void some_method_with_var (
//			var var_in_signature_not_permitted
	){
		var s="string var"; // inferred type is String
//		var n=null; no null initialization
		var i=1; // inferred type is int
		var d=2.2;

//		d=d+"cannot add a string if inferred type is double";

		i=i+1;
		s=s+"iable";
	}
}
