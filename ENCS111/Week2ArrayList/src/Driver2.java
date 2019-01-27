import java.util.ArrayList;
import java.util.Stack;

public class Driver2 {

    private ArrayList<String> closes;
    private ArrayList<String> opens;

    public static void main(String[] args) {
        new Driver2().run();
    }

    public void run(){
        System.out.println(isValid("()(()){([()]())}"));
        System.out.println(isValid("(}"));
        System.out.println(isValid("({)}"));
        System.out.println(isValid("[]()"));
        System.out.println(isValid("([])"));
        System.out.println(isValid(")("));
        System.out.println();
        System.out.println(isValid(""));
    }

    //obsolete
    public boolean isValid2(String formula){
        char[] chars = formula.toCharArray();
        Stack stack = new Stack();
        for (char letter : chars) {
            String a = Character.toString(letter);
            if (a.equals("{") || a.equals("[") || a.equals("(")){
                stack.push(a);
            }else if (!stack.empty()){
                if (a.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                }else if (a.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                }else if (a.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        return stack.empty();
    }

    public boolean isValid(String s){
        init();
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (char letter : chars) {
            String symbol = Character.toString(letter);
            if (isOpen(symbol)){
                stack.push(symbol);
            } else if (!stack.empty() && isMatch(stack.peek(), symbol)){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    private void init(){
        opens = new ArrayList<>();
        opens.add("{");
        opens.add("[");
        opens.add("(");

        closes = new ArrayList<>();
        closes.add("}");
        closes.add("]");
        closes.add(")");
    }

    private boolean isOpen(String symbol){
        return opens.contains(symbol);
    }

    private boolean isMatch(String open, String close){
        int openIndex = opens.indexOf(open);
        int closeIndex = closes.indexOf(close);
        return openIndex == closeIndex;
    }

}
