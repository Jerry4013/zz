package assignment4b;

import java.util.ArrayList;
import java.util.HashMap;

public class MinSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap1.put(list1[i], i);
        }
        ArrayList<String> results = new ArrayList<>();
        int minSum = list1.length + list2.length - 2;
        for (int i = 0; i < list2.length; i++) {
            Integer integer = hashMap1.get(list2[i]);
            if (integer != null && integer + i < minSum){
                minSum = integer + i;
                results.clear();
                results.add(list2[i]);
            } else if (integer != null && integer + i == minSum){
                results.add(list2[i]);
            }
        }
        String[] result = new String[results.size()];
        return results.toArray(result);
    }
}
