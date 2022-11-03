package linkedin;

public class float_precision {
    public void go(){
//		float a = 0.5; ERROR possible lossy conversion from double to float
//		float a = (double)0.5; ERROR possible lossy conversion from double to float
//		float a = 0.5d; ERROR possible lossy conversion from double to float
        System.out.println( "Test Float / double");
        float a1 = 0.5f;
        float a2 = (float)0.5;

        double a3 = 0.5;
        double a4 = 0.5d;
        double a5 = 0.5f;
        double a6 = (double)0.5;

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);
    }
}
