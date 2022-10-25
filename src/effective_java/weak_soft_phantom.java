package effective_java;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class some_random_class{
    double m_double;
    some_random_class(){
        m_double=Math.random();
    }
    public double get_content(){
        return m_double;
    }
}
public class weak_soft_phantom {
    private void strong_reference() {
        System.out.println("\nDemonstration of strong reference (the usual kind)");
        some_random_class s_r_c_1 = new some_random_class();
        some_random_class s_r_c_2 = s_r_c_1;
        s_r_c_1.m_double=1.234567;
        System.out.println("s_r_c_1 has `"+s_r_c_1.get_content()+"`, s_r_c_2 has `"+s_r_c_2.get_content()+"`");
        s_r_c_2=null; // s_r_c_2 is now available to the GC to be disposed of
        System.out.println("s_r_c_1 has `"+s_r_c_1.get_content()+" while s_r_c_2 is null; calling get_content() on it would result in NullPointerException");
        s_r_c_1=null; // s_r_c_1 is now available to the GC to be disposed of
        System.out.println("both s_r_c_1 and s_r_c_2 are null, either will give NullPointerException");
    }


    private void weak_reference() {
        System.out.println("\nDemonstration of weak reference");
        some_random_class s_r_c_1 = new some_random_class();
        s_r_c_1.m_double=9.87654321;
        WeakReference<some_random_class> w_reference = new WeakReference<>(s_r_c_1);
        s_r_c_1 = null;
        System.out.println("Set object reference to null");
        if( null==w_reference.get() )
            System.out.println("Weak reference  is now null");
        else {
            some_random_class s_r_c_2= w_reference.get();
            System.out.println("Weak reference is still valid, content is "+s_r_c_2.get_content());
        }
        System.out.println("Now calling GC");
        System.gc(); //marking the object for a further processing.
        if( null==w_reference.get() )
            System.out.println("Weak reference is null"); // almost impossible
        else
            System.out.println("Weak reference still valid");
    }


    private void soft_reference() {
        System.out.println("\nDemonstration of SOFT reference");
        some_random_class s_r_c_1 = new some_random_class();
        s_r_c_1.m_double=9.87654321;
        SoftReference<some_random_class> s_reference = new SoftReference<>(s_r_c_1);
        s_r_c_1 = null;
        System.out.println("Set object reference to null");
        if( null==s_reference.get() )
            System.out.println("Soft reference  is now null");
        else {
            some_random_class s_r_c_2= s_reference.get();
            System.out.println("Soft reference is still valid, content is "+s_r_c_2.get_content());
        }
        System.out.println("Now calling GC");
        System.gc();
        if( null==s_reference.get() )
            System.out.println("Soft reference is null"); // unlikely
        else
            System.out.println("Soft reference is still valid; it will be discarded only when memory is full.");
    }

    private void phantom_reference() {
        System.out.println("\nDemonstration of PHANTOM reference");
        some_random_class s_r_c_1 = new some_random_class();
        s_r_c_1.m_double=9.87654321;
        ReferenceQueue<some_random_class> ref_queue = new ReferenceQueue<>();
        PhantomReference<some_random_class> ph_reference = new PhantomReference<>(s_r_c_1, ref_queue);
        s_r_c_1 = null;
        System.out.println("Set object reference to null");
        if( null==ph_reference.get() )
            System.out.println("Phantom reference  is now null");
        else {
            some_random_class s_r_c_2= ph_reference.get();
            System.out.println("Phantom reference is still valid, content is "+s_r_c_2.get_content());
        }
        if(ph_reference.refersTo(null))
            System.out.println("The reference has been cleared");
        else
            System.out.println("The reference has NOT been cleared");

        System.out.println("Now calling GC");
        System.gc();
        if( null==ph_reference.get() )
            System.out.println("Phantom reference is null"); // unlikely
        else
            System.out.println("Phantom reference is still valid; it will be discarded only when memory is full.");
        if(ph_reference.refersTo(null))
            System.out.println("The reference has been cleared");
        else
            System.out.println("The reference has NOT been cleared");
    }

    public void go(){
        strong_reference();
        weak_reference();
        soft_reference();
        phantom_reference();
    }



}
