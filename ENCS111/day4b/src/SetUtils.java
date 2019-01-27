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

        set1 = resetSet1(set1);
        Set intersection = intersect(set1, set2);
        System.out.println(intersection);

        set1 = resetSet1(set1);
        Set subtraction = subtract(set1, set2);
        System.out.println(subtraction);
    }

    public static Set union(Set set1, Set set2){
        set1.addAll(set2);
        return set1;
    }

    public static Set intersect(Set set1, Set set2){
        set1.retainAll(set2);
        return set1;
    }

    public static Set subtract(Set set1, Set set2){
        set1.removeAll(set2);
        return set1;
    }

    private Set resetSet1(Set set){
        set.clear();
        set.add(1);
        set.add(2);
        return set;
    }
}
