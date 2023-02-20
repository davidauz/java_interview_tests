package effective_java;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class some_random_class {
    double m_double;
    String m_usage_type;
    some_random_class(String strong_reference){
        m_usage_type=strong_reference;
        m_double=Math.random();
    }
    public String get_content(){
        return "'"+m_usage_type+"', has "+m_double;
    }

}
public class weak_soft_phantom {
    private void strong_reference() {
            System.out.println("\nDemonstration of STRONG Reference (the usual kind)");
            some_random_class s_r_r_c = new some_random_class("Strong Reference");
            some_random_class s_r_c_2 = s_r_r_c;
            s_r_r_c.m_double = 1.234567;
            System.out.println("First instance: \"" + s_r_r_c.get_content() + "\", Second instance: \"" + s_r_c_2.get_content() + "\"");
            s_r_c_2 = null; // s_r_c_2 is now available to the GC to be disposed of
            System.out.println("After setting second instance to null, First Instance is `" + s_r_r_c.get_content() + " while second instance is null");
            try{
                s_r_c_2.get_content();
            }catch(NullPointerException e){
                System.out.println("Got NullPointerException calling get_content() on second instance, as expected");
            }
            s_r_r_c = null; // s_r_r_c is now available to the GC to be disposed of
            System.out.println("After setting first instance to null too, calling get_content() on either will give NullPointerException");
    }


    private void weak_reference() {
        System.out.println("\nDemonstration of WEAK reference");
        some_random_class w_r_r_c = new some_random_class("Weak Reference");
        w_r_r_c.m_double=9.87654321;
//      Put object reference in WeakReference
        WeakReference<some_random_class> w_reference = new WeakReference<>(w_r_r_c);
        // Set object reference to null
        w_r_r_c = null;
        if( null==w_reference.get() )
            System.out.println("Weak reference  is now null");
        else {
            some_random_class s_r_c_2= w_reference.get();
            System.out.println("Object reference is null but weak reference is still valid: \""+s_r_c_2.get_content()+"\"");
        }
        System.gc(); //marking the object for a further processing.
        if( null==w_reference.get() )
            System.out.println("After gc(): WEAK reference is null");
        else
            System.out.println("Aftwer gc(): WEAK reference still valid");
    }


    private void soft_reference() {
        System.out.println("\nDemonstration of SOFT reference");
        some_random_class s_r_r_c = new some_random_class("Soft Reference");
        s_r_r_c.m_double=9.87654321;
        SoftReference<some_random_class> s_reference = new SoftReference<>(s_r_r_c);
        s_r_r_c = null; // Set object reference to null
        if( null==s_reference.get() )
            System.out.println("Soft reference is now null");
        else {
            some_random_class s_r_c_2= s_reference.get();
            System.out.println("Soft reference is still valid, content is \""+s_r_c_2.get_content()+"\"");
        }
        System.gc();
        if( null==s_reference.get() )
            System.out.println("After calling gc() Soft reference is null");
        else {
            some_random_class s_r_c_2= s_reference.get();
            System.out.println("After calling gc(), Soft reference is still valid: \"" + s_r_c_2.get_content() + "\"; it will be discarded only when memory is full.");
        }
    }

    private void phantom_reference() {
        System.out.println("\nDemonstration of PHANTOM reference");
        some_random_class f_r_r_c = new some_random_class("Phantom Reference");
        f_r_r_c.m_double=9.87654321;
        ReferenceQueue<some_random_class> ref_queue = new ReferenceQueue<>();
        PhantomReference<some_random_class> ph_reference = new PhantomReference<>(f_r_r_c, ref_queue);
        f_r_r_c = null;
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
