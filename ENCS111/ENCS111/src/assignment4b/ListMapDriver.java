package assignment4b;

public class ListMapDriver {
    public static void main(String[] args) {
        ListMap<String, Integer> listMap = new ListMap<>();
        listMap.add("A", 3);
        System.out.println(listMap.get("A"));
        listMap.add("A", 4);
        System.out.println(listMap.get("A"));
        listMap.add("B", 5);
        System.out.println(listMap.get("A"));
        System.out.println(listMap.get("B"));

        System.out.println();
        listMap.add("A", 3);
        System.out.println(listMap.get("A"));
        listMap.removeFirst("A", 3);
        System.out.println(listMap.get("A"));
        listMap.removeFirst("A", 4);
        System.out.println(listMap.get("A"));
        listMap.removeFirst("A", 3);
        System.out.println(listMap.get("A"));

        System.out.println();
        listMap.add("A", 3);
        listMap.add("A", 4);
        listMap.add("A", 3);
        listMap.add("A", 6);
        System.out.println(listMap.get("A"));
        listMap.removeLast("A", 3);
        System.out.println(listMap.get("A"));

        System.out.println();
        listMap.remove("A");
        listMap.add("A", 3);
        listMap.add("A", 4);
        listMap.add("A", 3);
        System.out.println(listMap.get("A"));
        listMap.removeAll("A", 3);
        System.out.println(listMap.get("A"));

        System.out.println(listMap.containsKey("A"));
        System.out.println(listMap.containsKey("B"));
        System.out.println(listMap.containsKey("C"));
    }
}
