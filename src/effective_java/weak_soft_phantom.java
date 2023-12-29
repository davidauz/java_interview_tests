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
    public void strong_reference() {
            System.out.println("\nDemonstration of STRONG Reference (the usual kind)");
            some_random_class strong_reference_1 = new some_random_class("Strong Reference");
            some_random_class strong_reference_2 = strong_reference_1;
            strong_reference_1.m_double = 1.234567;
            System.out.println("First instance: \""
                + strong_reference_1.get_content()
                + "\", Second instance: \""
                + strong_reference_2.get_content()
                + "\""
            );
            strong_reference_2 = null; // now available to the GC to be disposed of
            System.out.println("After setting second instance to null, First Instance is `"
                + strong_reference_1.get_content()
                + " while second instance is null"
            );
            try{
                strong_reference_2.get_content();
            }catch(NullPointerException e){
                System.out.println("Got NullPointerException calling get_content() on second instance, as expected");
            }
            strong_reference_1 = null; // now available to the GC to be disposed of
            System.out.println("After setting first instance to null too, calling get_content() on either will give NullPointerException");
    }


    public void weak_reference() {
        System.out.println("\nDemonstration of WEAK reference");
        some_random_class weak_reference_1 = new some_random_class("Weak Reference");
        weak_reference_1.m_double=9.87654321;
//      Put object reference in WeakReference
        WeakReference<some_random_class> weak_reference_2 = new WeakReference<>(weak_reference_1);
// Set object reference to null
        weak_reference_1 = null;
        if( null==weak_reference_2.get() ) // first try
            System.out.println("Weak reference 2 is now null");
        else {
            some_random_class weak_reference_3= weak_reference_2.get();
            System.out.println("Reference 2 is null but weak reference is still valid: \""+weak_reference_3.get_content()+"\"");
        }
        System.gc(); //marking the object for a further processing.
        if( null==weak_reference_2.get() )
            System.out.println("After gc(): WEAK reference is null");
        else
            System.out.println("Aftwer gc(): WEAK reference still valid");
    }


    public void soft_reference() {
        System.out.println("\nDemonstration of SOFT reference");
        some_random_class orig_instance = new some_random_class("Soft Reference");
        orig_instance.m_double=9.87654321;
        SoftReference<some_random_class> soft_reference = new SoftReference<>(orig_instance);
        orig_instance = null; // Set object reference to null
        if( null==soft_reference.get() )
            System.out.println("Soft reference is now null");
        else {
            some_random_class soft_reference_2= soft_reference.get();
            System.out.println("Soft reference is still valid, content is \""+soft_reference_2.get_content()+"\"");
        }
        System.gc();
        if( null==soft_reference.get() )
            System.out.println("After calling gc() Soft reference is null");
        else {
            some_random_class soft_reference_3= soft_reference.get();
            System.out.println("After calling gc(), Soft reference is still valid: \"" + soft_reference_3.get_content() + "\"; it will be discarded only when memory is full.");
        }
    }

    public void phantom_reference() {
        System.out.println("\nDemonstration of PHANTOM reference");
        some_random_class original_instance = new some_random_class("Phantom Reference");
        original_instance.m_double=9.87654321;
        ReferenceQueue<some_random_class> ref_queue = new ReferenceQueue<>();
        PhantomReference<some_random_class> ph_reference = new PhantomReference<>(original_instance, ref_queue);
        original_instance = null;
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
}
