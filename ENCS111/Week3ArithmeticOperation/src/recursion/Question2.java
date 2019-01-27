package recursion;

public class Question2 {
    public static void main(String[] args) {
        new Question2().run();
    }

    private void run() {
        System.out.println(reverse("sdfgerg"));
    }

    public String reverse(String word){
        int length = word.length();
        if (length < 2){
            return word;
        } else {
            return word.substring(length-1) + reverse(word.substring(0, length - 1));
        }
    }
}
