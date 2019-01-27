package day5a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 4);
        System.out.println(map.get("A"));

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + map.get(key));
        }

        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}

