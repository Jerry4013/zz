package recursion;

public class Max {
    public static void main(String[] args) {
        new Max().run();
    }

    private void run() {
        int[] arr = {5, 6, 9, 15, 16, 3, 22};
        System.out.println(calculateMax(arr, arr.length-1));
    }

    public int calculateMax(int[] arr, int index){
        if (index == 0){
            return arr[0];
        } else {
            return max(calculateMax(arr, index-1), arr[index]);
        }
    }

    private int max(int a, int b) {
        return a >= b ? a : b;
    }


}
