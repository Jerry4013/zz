import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {
    public static void main(String[] args) {
        new MergeSort().run();
    }

    private void run() {
        int[] arr = {6, 7, 3, 8, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr){
        LinkedList<Integer> list = mergeSortRecur(arr,0, arr.length - 1);
        int i = 0;
        for (Integer integer : list) {
            arr[i] = integer;
            i++;
        }
    }

    private LinkedList<Integer> mergeSortRecur(int[] arr, int from, int to){
        LinkedList<Integer> r = new LinkedList<>();
        if (from == to){
            r.add(arr[from]);
            return r;
        }
        LinkedList<Integer> r1, r2;
        int mid = (from + to) / 2;
        r1 = mergeSortRecur(arr, from, mid);
        r2 = mergeSortRecur(arr, mid + 1, to);
        r = merge(r1, r2);
        return r;
    }

    private LinkedList<Integer> merge(LinkedList<Integer> r1, LinkedList<Integer> r2){
        LinkedList<Integer> r = new LinkedList<>();
        while (!r1.isEmpty() && !r2.isEmpty()) {
            if (r1.peek() < r2.peek()) {
                r.add(r1.remove());
            } else {
                r.add(r2.remove());
            }
        }
        while (!r1.isEmpty()){
            r.add(r1.remove());
        }
        while (!r2.isEmpty()){
            r.add(r2.remove());
        }
        return r;
    }
}
