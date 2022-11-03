package generic;

import java.util.*;

public class collections {
    public void go() {
        test_hash_map();
        test_hash_set();
    }

    private void test_hash_set() {
        Collection<String> string_hash_set = new HashSet<>();
        System.out.println("HashSet");
        string_hash_set.add("ABBA");
        string_hash_set.add("BABBA");
        string_hash_set.add("ABBAB");
        System.out.println("Before adding 'BABBA' to : "+string_hash_set+" (again)");
        string_hash_set.add("BABBA");
        System.out.println("HashSet:"+string_hash_set+"; no duplicates!");

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
