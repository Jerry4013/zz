package zz;
import java.util.Map;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Map<String, String> envs = System.getenv();
        // 'Sy' Select '.get' Select ';' Command+Option+v Enter 'envs' Enter

        Set<Map.Entry<String, String>> entries = envs.entrySet();
        // 'en' Select '.ent' Select ';' Command+Option+v Enter Enter

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}