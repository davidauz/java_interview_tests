package generic;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class collections {
    public void go() {
        test_hash_map();

    }

    private void test_hash_map() {
        //public abstract class AbstractMap<K, V> implements Map<K, V>
        //public interface Map<K, V>
        Map<String, String> hash_map = new HashMap<>(); // public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable
        hash_map.put("1", "ABBA");
        hash_map.put("2", "BABBA");
        hash_map.put("3", "ABBAB");
        System.out.println("Before: "+hash_map);
        hash_map.put("2", "ZZZ");
        System.out.println("After:"+hash_map+"; no duplicates!");
    }
}
