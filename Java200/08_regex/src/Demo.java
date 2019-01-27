import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {

        String source = "123";
        String regExp = "\\d+";

        System.out.println(source.matches(regExp));

        String line = "123  456 78 9";
        String[] split = line.split("\\s+");
        for (String s : split) {
//            System.out.println(s);
        }

        source = "haha 8888 7777";
        regExp = "(\\d)\\1\\1\\1";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(source);
        boolean result = matcher.find();
        System.out.println(result);

        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());

        result = matcher.find();
        System.out.println(result);

        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());

        System.out.println(matcher.group(1));


        source = "哈哈 [抠鼻] [哭]";
        regExp = "\\[([^\\[\\]]+)\\]";
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(source);
        result = matcher.find();
        System.out.println(result);

        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        System.out.println(matcher.group(1));

        result = matcher.find();
        System.out.println(result);

        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        System.out.println(matcher.group(1));

    }
}
