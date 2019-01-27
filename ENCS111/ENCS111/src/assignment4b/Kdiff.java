package assignment4b;


import java.util.*;

public class Kdiff {

    public static void main(String[] args) {
        new Kdiff().run();
    }

    private void run() {
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(findPairs(nums, 2));
    }

    public int findPairs(int[] nums, int k){
        if (k < 0 ){
            return 0;
        }
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> indexes = hashMap.get(nums[i]);
            if (indexes == null) {
                indexes = new HashSet<>();
            }
            indexes.add(i);
            hashMap.put(nums[i], indexes);
        }

        int counter = 0;
        Set<Integer> keys = hashMap.keySet();
        if (k != 0){
            for (Integer key : keys) {
                if (keys.contains(key + k)){
                    counter++;
                }
            }
            return counter;
        }
        for (Integer key : keys) {
            HashSet<Integer> indexes = hashMap.get(key);
            if (indexes.size() > 1){
                counter++;
            }
        }
        return counter;
    }

    public int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        if (k == 0) {
            HashSet<Integer> duplicates = new HashSet<>();
            for (int num : nums) {
                if (set.add(num) == false){
                    duplicates.add(num);
                }
            }
            return duplicates.size();
        }
        for (int num : nums) {
            set.add(num);
        }
        int counter = 0;
        for (Integer integer : set) {
            if (set.contains(integer + k)){
                counter++;
            }
        }
        return counter;
    }
}
