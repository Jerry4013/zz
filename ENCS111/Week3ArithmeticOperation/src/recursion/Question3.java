package recursion;

public class Question3 {
    public static void main(String[] args) {
        new Question3().run();
    }

    private void run() {
        System.out.println(power2(9));
        System.out.println(power2Constant(9));
    }

    //倍数降级递归
    public int power2(int power){
        if (power == 0){
            return 1;
        } else if (power % 2 == 0){
            return power2(power / 2) * power2(power / 2);
        } else {
            return power2(power / 2) * power2(power / 2) * 2;
        }
    }

    //常量降级递归
    public int power2Constant(int power){
        if (power == 0){
            return 1;
        } else {
            return power2Constant(power - 1) * 2;
        }
    }
}
