package design_patterns;

class singleton_object{
    // this is the only instance that will ever exist
    private static singleton_object instance = new singleton_object();
    private int m_times;


    // private constructor ensures that nobody else can call it
    private singleton_object(){m_times=0;}

    // the only way to get an instance:
    public static singleton_object getInstance(){ return instance; }

    public int get_times_called(){
        return ++m_times;
    }
}
public class singleton_pattern {
    public void go() {
        // This is silly because I am doing all this in a single file.
        // Actually the reason for this would be to have a single object existing in the whole project.
        System.out.println("Singleton has been called "+singleton_object.getInstance().get_times_called()+" times.");
        System.out.println("Singleton has been called "+singleton_object.getInstance().get_times_called()+" times.");
        System.out.println("Singleton has been called "+singleton_object.getInstance().get_times_called()+" times.");
    }
}
