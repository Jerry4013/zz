public class BinarySearch {
    public static void main(String[] args) {
        new BinarySearch().run();
    }

    private void run() {
        int[] arr = {1, 5, 6, 8, 10, 11, 13, 19, 29, 54, 68, 69, 71};
        System.out.println(binarySearch(arr, 9));
    }

    public static int binarySearch(int[] array, int query){
        return binarySearch(array, query, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int query, int from, int to){
        if (from > to){
            return -1;
        }
        int mid = (from + to) / 2;
        if (query == array[mid]){
            return mid;
        }
        if (query < array[mid]){
            return binarySearch(array, query, from, mid - 1);
        }
        if (query > array[mid]){
            return binarySearch(array, query, mid + 1, to);
        }
        return -1;
    }

}
