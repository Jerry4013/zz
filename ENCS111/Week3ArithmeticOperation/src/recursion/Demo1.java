package recursion;

public class Demo1 {
    public static void main(String[] args) {
        new Demo1().run();
    }

    private void run() {
        System.out.println(f(3));
        jump1(5);
    }

    private int f(int a) {
        if (a == 0) {
            return 0;
        }
        return a + f(a - 1);
    }

    private void jump1(int times){
        System.out.println("hey, 我在这");
        if (times == 0) {
            return;
        }
        jump2(times - 1);
    }

    private void jump2(int times) {
        System.out.println("ya, I'm here");
        if (times == 0) {
            return;
        }
        jump1(times - 1);
    }
}
