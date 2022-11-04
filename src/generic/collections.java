package generic;

import java.util.*;

public class collections {
    public void go() {
        test_hash_map();
        test_hash_set();
        test_list();
    }

    private void test_list() {
        test_array_list();
        test_linked_list();
        test_vector();
        test_stack();
    }

    private void test_stack() {
        Stack<String> string_stack = new Stack<>();
        System.out.println("Stack");
        string_stack.add("ABBA");
        string_stack.add("BABBA");
        string_stack.add("ABBAB");
        System.out.println("Before adding 'BABBA' to : "+string_stack+" (again)");
        string_stack.add("BABBA");
        System.out.println("Stack does not care about duplicates:"+string_stack);
        System.out.println("You have the standard stack operations like pop: "+string_stack.pop()+"\n");
    }

    private void test_vector() {
        Vector<String> string_vector = new Vector<>();
        System.out.println("Vector");
        string_vector.add("ABBA");
        string_vector.add("BABBA");
        string_vector.add("ABBAB");
        System.out.println("Before adding 'BABBA' to : "+string_vector+" (again)");
        string_vector.add("BABBA");
        System.out.println("Vector:"+string_vector+"; as many duplicates as you want!");
        System.out.println("Vector is just like ArrayList, plus it is synchronized.\n");
    }

    private void test_array_list() {
        ArrayList<String> string_array_list = new ArrayList<>();
        System.out.println("ArrayList");
        string_array_list.add("ABBA");
        string_array_list.add("BABBA");
        string_array_list.add("ABBAB");
        System.out.println("Before adding 'BABBA' to : "+string_array_list+" (again)");
        string_array_list.add("BABBA");
        System.out.println("ArrayList:"+string_array_list+"; as many duplicates as you want!");
        System.out.println("In addition you can also get any element by the index, here is index 2: "+string_array_list.get(2)+"\n");
    }

    private void test_linked_list() {
        LinkedList<String> string_linked_list = new LinkedList<>();
        System.out.println("LinkedList");
        string_linked_list.add("ABBA");
        string_linked_list.add("BABBA");
        string_linked_list.add("ABBAB");
        System.out.println("Before adding 'BABBA' to : "+string_linked_list+" (again)");
        string_linked_list.add("BABBA");
        System.out.println("LinkedList:"+string_linked_list+"; as many duplicates as you want!");
        System.out.println("In addition you also can get the element by the index, here is element 2: "+string_linked_list.get(2)+", the first element: "+string_linked_list.getFirst()+" or the last: "+string_linked_list.getLast()+"\n");
    }

    private void test_hash_set() {
        Collection<String> string_hash_set = new HashSet<>();
        System.out.println("HashSet");
        string_hash_set.add("ABBA");
        string_hash_set.add("BABBA");
        string_hash_set.add("ABBAB");
        System.out.println("Before adding 'BABBA' to : "+string_hash_set+" (again)");
        string_hash_set.add("BABBA");
        System.out.println("HashSet:"+string_hash_set+"; no duplicates!\n");

    }

    private void test_hash_map() {
        //public abstract class AbstractMap<K, V> implements Map<K, V>
        //public interface Map<K, V>
        Map<String, String> hash_map = new HashMap<>(); // public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable
        System.out.println("HashMap");
        hash_map.put("1", "ABBA");
        hash_map.put("2", "BABBA");
        hash_map.put("3", "ABBAB");
        System.out.println("Adding '2, ZZZ': to "+hash_map);
        hash_map.put("2", "ZZZ");
        System.out.println("No duplicate indexes: "+hash_map+"\n");
    }
}
