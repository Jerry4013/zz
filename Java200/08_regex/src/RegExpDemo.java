import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpDemo {
    public static void main(String[] args) {
        new RegExpDemo().run();
    }

    public void run(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Reg:");
            String regExp = scanner.nextLine();
            if (regExp.equals("")) {
                break;
            }


            while (true) {
                System.out.print("Str:");
                String source = scanner.nextLine();
                if (source.equals("")) {
                    break;
                }

                find(source, regExp);
            }
        }
    }

    public void find(String source, String regExp) {

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            String range = matcher.start() + " - " + matcher.end();
            String match = matcher.group();
            System.out.println(range + " : " + match);
        }
    }
}
