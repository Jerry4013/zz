package zz;

public class Math {
    // psvm
    public static void main(String[] args) {

        // -add v1 v2 -> sum
        // -sub v1 v2 -> subtract
        if (args.length != 3) {

            //sout
            System.out.println("illegal arguments");
            return;
        }

        String operator = args[0];
        String value1 = args[1];
        String value2 = args[2];
        int num1 = Integer.valueOf(value1);
        int num2 = Integer.valueOf(value2);

        if (operator.equals("--add") || operator.equals("-a")) {
            System.out.println(num1 + num2);
        } else if (operator.equals("-sub")) {
            System.out.println(num1 - num2);
        }


    }

}
