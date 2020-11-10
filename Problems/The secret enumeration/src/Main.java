import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String reg = "STAR.*";
        Pattern pattern = Pattern.compile(reg);
        int count = 0;
        for (Secret s : Secret.values()) {
            Matcher matcher = pattern.matcher(s.toString());
            if (matcher.matches()) {
                count++;
            }
        }
        System.out.println(count);
    }
}

/* At least two constants start with STAR
enum Secret {
    STAR, CRASH, START
//    , // ...
}
*/