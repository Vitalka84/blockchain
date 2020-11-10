import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String subStr = scanner.nextLine();
        Pattern p = Pattern.compile(subStr);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()) {
            count++;
        }

        System.out.println(count);
        // put your code here
    }
}
