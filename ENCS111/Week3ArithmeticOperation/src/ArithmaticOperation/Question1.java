package ArithmaticOperation;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question1 {

    private Stack<Double> nums;
    private Stack<Operator> opes;
    private double tempNum;
    private Operator tempOpe;

    public static void main(String[] args) {
        new Question1().run();
    }

    public void run() {
        System.out.println(resolve("2+3*4-5"));
        System.out.println(resolve("1+9*4+8+4+2/8/9"));
        System.out.println(resolve("8/4+6*3-5/2*3"));

        System.out.println(resolveEnhance1("8   + 6 * 4 + 87-86"));
        System.out.println(resolveEnhance1("45/5-6 +18 *2  -37"));
        System.out.println(resolveEnhance1(" 8746   * 64  /28  -1 -946"));

        System.out.println(resolveEnhance2("5+8*2-4*(4+1)+9*(1+2)"));
        System.out.println(resolveEnhance2("-( -5.5)+8*2-4*(4-(6-1))+9*(1+2)"));
    }

    public double resolve(String formula){
        nums = new Stack<>();
        opes = new Stack<>();
        formula = formula + "$";
        char[] chars = formula.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            tempNum = Integer.parseInt(String.valueOf(chars[i]));
            tempOpe = new Operator(chars[i+1]);
            if (i == 0 || tempOpe.compareTo(opes.peek()) > 0){
                //temp operator has a HIGHER priority than the top one in the stack
                pushBoth();
            } else if (tempOpe.compareTo(opes.peek()) <= 0) {
                //temp operator has a LOWER OR SAME priority than the top one in the stack
                while (!nums.empty() && !opes.empty() && tempOpe.compareTo(opes.peek()) <= 0){
                    tempNum = Operator.calculate(nums.peek(), tempNum, opes.peek().getSymbol());
                    popBoth();
                }
                pushBoth();
            }
        }
        return nums.peek();
    }

    //增强版1
    public double resolveEnhance1(String formula){
        nums = new Stack<>();
        opes = new Stack<>();
        formula = formula + "$";
        String regExp = "(\\d+)\\s*(\\D)\\s*";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(formula);
        boolean firstIteration = true;
        while (matcher.find()){
            tempNum = Integer.parseInt(matcher.group(1));
            tempOpe = new Operator(matcher.group(2).charAt(0)) ;
            if ( firstIteration || tempOpe.compareTo(opes.peek()) > 0){
                pushBoth();
            } else if (tempOpe.compareTo(opes.peek()) <= 0) {
                while (!nums.empty() && !opes.empty() && tempOpe.compareTo(opes.peek()) <= 0){
                    tempNum = Operator.calculate(nums.peek(), tempNum, opes.peek().getSymbol());
                    popBoth();
                }
                pushBoth();
            }
            firstIteration = false;
        }
        return nums.peek();
    }

    //增强版2
    public double resolveEnhance2(String formula){
        while (formula.contains("(")) {
            formula = findSubFormula(formula);
        }
        nums = new Stack<>();
        opes = new Stack<>();
        formula = formula.replaceAll("--", "");
        formula = formula + "$";
        String regExp = "(-*\\d+\\.?\\d*)\\s*(\\D)\\s*";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(formula);
        boolean firstIteration = true;
        while (matcher.find()){
            tempNum = Double.parseDouble(matcher.group(1));
            tempOpe = new Operator(matcher.group(2).charAt(0)) ;
            if ( firstIteration || tempOpe.compareTo(opes.peek()) > 0){
                pushBoth();
            } else if (tempOpe.compareTo(opes.peek()) <= 0) {
                while (!nums.empty() && !opes.empty() && tempOpe.compareTo(opes.peek()) <= 0){
                    tempNum = Operator.calculate(nums.peek(), tempNum, opes.peek().getSymbol());
                    popBoth();
                }
                pushBoth();
            }
            firstIteration = false;
        }
        return nums.peek();
    }

    private void pushBoth(){
        nums.push(tempNum);
        opes.push(tempOpe);
    }

    private void popBoth(){
        nums.pop();
        opes.pop();
    }

    private boolean stackIsEmpty(){
        return true;
    }

    private int findClosedParenthesis(String expression){
        Stack<Character> symbol = new Stack<>();
        symbol.push('(');
        int index = expression.indexOf("(");
        while (!symbol.empty()){
            index++;
            if (expression.charAt(index) == '('){
                symbol.push('(');
            } else if (expression.charAt(index) == ')') {
                symbol.pop();
            }
        }
        return index;
    }

    private String findSubFormula(String formula){
        if (formula.contains("(")){
            String subFormula;
            int start = formula.indexOf("(");
            int end = findClosedParenthesis(formula);
            subFormula = formula.substring(start+1, end);
            formula = formula.substring(0, start) + resolveEnhance2(subFormula)
                    + formula.substring(end+1);
        }
        return formula;
    }
}
