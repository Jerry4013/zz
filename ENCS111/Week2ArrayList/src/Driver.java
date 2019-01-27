
public class Driver {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(4);
        System.out.println(arrayList);
        arrayList.add(6);
        System.out.println(arrayList);
        arrayList.insert(2, 3);
        System.out.println(arrayList);
        arrayList.pop();
        System.out.println(arrayList);
        System.out.println("The number at index 1 is: " + arrayList.get(1));
        arrayList.remove(1);
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
    }
}
