package linkedin;

import java.util.*;

import static java.lang.Math.random;

class strange_property implements Comparable<strange_property> {
    double quark_color;
    strange_property(){quark_color=random();}
    public String write() {return String.valueOf(quark_color);}

    @Override
    public int compareTo(strange_property s1) {
        if ( s1.quark_color==quark_color )
                    return 0;
        else if ( s1.quark_color<quark_color)
                    return 1;
        else
            return -1;
    }

    //public int compareTo(linkedin.strange_property s1) {
//            return s1.quark_color<quark_color;
//    }
}

class Pencil {
    private String str_color;
    private int n_length;
    strange_property dr_strange;
    public Pencil(String str, int l) {
            str_color=str;
            n_length=l;
            dr_strange=new strange_property();
    }

    public void write() {
        System.out.println("linkedin.Pencil writing "+ str_color +" length: "+n_length+", strange property: "+dr_strange.write()+".");
    }

    public String get_color() {return str_color;}
    public int get_length() {return n_length;}

    public strange_property get_strange_property() {return dr_strange;}
}

/* only useful when there is no comparing
class pencil_sorter implements Comparator<linkedin.Pencil> {
    @Override
    public int compare(linkedin.Pencil t1, linkedin.Pencil t2) {
        return t1.get_color().compareTo(t2.get_color());
    }
}
*/

public class test_iterators {


    public void go() {
        List<Pencil> pencilCase = new ArrayList<Pencil>();
        pencilCase.add(new Pencil("Red", 1));
        pencilCase.add(new Pencil("Yellow", 3));
        pencilCase.add(new Pencil("Brown", 7));
        pencilCase.add(new Pencil("Green", 2));
        pencilCase.add(new Pencil("Blue", 9));
        pencilCase.add(new Pencil("Orange", 12));

        System.out.println("\nArray is unsorted");
        for(Pencil pencil: pencilCase)
            pencil.write();

        Comparator<Pencil> pencil_color_comparator = Comparator.comparing(Pencil::get_color);
        Collections.sort(pencilCase, pencil_color_comparator);
        System.out.println("\nArray is sorted by color:");
        for(Pencil pencil: pencilCase)
            pencil.write();

        Comparator<Pencil> pencil_length_comparator = Comparator.comparing(Pencil::get_length);
        Collections.sort(pencilCase, pencil_length_comparator);
        System.out.println("\nArray is sorted by length:");
        for(Pencil pencil: pencilCase)
            pencil.write();

        Comparator<Pencil> pencil_strange_comparator = Comparator.comparing(Pencil::get_strange_property, (s1, s2) -> {
            return (s2.compareTo(s1));
        });
        Collections.sort(pencilCase, pencil_strange_comparator);
        System.out.println("\nArray is sorted by strange property:");
        for(Pencil pencil: pencilCase)
            pencil.write();
    }
}
