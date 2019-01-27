
public class ArrayList<S> {
    private int[] space = new int[4];
    private int size;

    public ArrayList() {
    }

    public ArrayList(int maxSize){
        space = new int[maxSize];
    }

    public void add(int value){
        if (size == space.length){
            doubleCapacity();
        }
        space[size] = value;
        size++;
    }

    public int get(int index){
        if (index >= 0 && index < size){
            return space[index];
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public int size(){
        return size;
    }

    public boolean pop(){
        if (size <= 0){
            return false;
        }
        size--;
        if (size <= space.length / 4){
            halveCapacity();
        }
        return true;
    }

    public void insert(int index, int value){
        if (index >= 0 && index <= size){
            if (size == space.length){
                doubleCapacity();
            }
            for (int i = size - 1 ; i >= index ; i--) {
                space[i+1] = space[i];
            }
            space[index] = value;
            size++;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove(int index){
        if (index >= 0 && index < size){
            for (int i = index; i < size - 1; i++) {
                space[i] = space [i+1];
            }
            size--;
            if (size <= space.length / 4){
                halveCapacity();
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    private void doubleCapacity(){
        copyToNewArray(space.length * 2);
    }

    private void halveCapacity(){
        copyToNewArray(space.length / 2);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < space.length; i++) {
            if (i < size){
                stringBuilder.append(space[i]);
            }else {
                stringBuilder.append("-");
            }
            if (i != space.length - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        String result = stringBuilder.toString();
        return result;
    }

    private void copyToNewArray(int newLength){
        int[] temp = space;
        space = new int[newLength];
        for (int i = 0; i < size; i++) {
            space[i] = temp[i];
        }
    }
}
