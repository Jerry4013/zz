public class QuickSelect {
    public static void main(String[] args) {
        new QuickSelect().run();
    }

    private void run() {
        int[] arr = {5, 3, 6, 9, 12, 1};
        System.out.println(quickSelect(arr, 0));
    }

    public int quickSelect(int[] arr, int rank){
        return quickSelect(arr, rank, 0, arr.length-1);
    }

    private int quickSelect(int[] arr, int rank, int first, int last){
        if (first == last){
            return arr[first];
        }
        int p = arr[first];
        int i = first + 1;
        for (int j = i; j <= last; j++) {
           if (arr[j] < p){
                swap(arr, i, j);
                i++;
           }
        }
        swap(arr, first, i - 1);
        if (rank < i - first){
            return quickSelect(arr, rank, first, i - 1);
        } else if (rank == i - first){
            return p;
        } else {
            return quickSelect(arr, rank - (i - first), i, last);
        }
        //此处如果使用早退出，编译器会强制要求最后返回一个默认值，因此使用了else
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
