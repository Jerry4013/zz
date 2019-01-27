package assignment4b;

import java.util.*;

public class ListMap<K, V> {
    //问题1：能否通过继承来实现?
    //问题2：能否避免使用LinkedList而只用List接口？因为题里只说的List

    private HashMap<K, List<V>> map = new HashMap<>();

    public void add(K key, V value){
        List<V> list = map.get(key);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(value);
        map.put(key, list);
    }

    public List<V> get(K key){
        List<V> list = map.get(key);
        return list;
    }

    public void removeFirst(K key, V value){
        List<V> list = map.get(key);
        list.remove(value);
        map.put(key, list);
    }

    public void removeLast(K key, V value){
        LinkedList<V> list = (LinkedList<V>) map.get(key);
        list.removeLastOccurrence(value);
        map.put(key, list);
    }

    public void removeAll(K key, V value){
        List<V> list = map.get(key);
        while (list.contains(value)){
            list.remove(value);
        }
        //这样做时间复杂度是不是就是n^2了？有没有办法降低？
        map.put(key, list);
    }

    public void remove(K key){
        List<V> list = map.get(key);
        list.clear();
        map.put(key, list);
    }

    public boolean containsKey(K key){
        return map.keySet().contains(key);
    }

}
