package assignment4b;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {

    public static void main(String[] args) {
        new SetUtils().test();
    }

    private void test() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(3);
        Set union = union(set1, set2);
        System.out.println(union);

        Set intersection = intersect(set1, set2);
        System.out.println(intersection);

        Set subtraction = subtract(set1, set2);
        System.out.println(subtraction);
    }

    public static Set union(Set set1, Set set2){
        Set result = new HashSet(set1);
        for (Object o : set2) {
            result.add(o);
        }
        return result;
    }

    public static Set intersect(Set set1, Set set2){
        Set result = new HashSet(set1);
        for (Object o : result) {
            if (!set2.contains(o)){
                result.remove(o);
            }
        }
        return result;
    }

    public static Set subtract(Set set1, Set set2){
        Set result = new HashSet(set1);
        for (Object o : set2) {
            result.remove(o);
        }
        return result;
    }
}
