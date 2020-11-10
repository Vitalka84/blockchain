import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        String res = "";
        boolean check = false;
        while (!check) {
            res = genString(a, b, c, n);
            if (!find(res)) {
                check = true;
            }
        }
        System.out.println(res);
        // write your code here
    }

    public static String genString(int a, int b, int c, int n) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        while (n > (a + b + c)) {
            if (a == 0) {
                a++;
            } else if (b == 0) {
                b++;
            } else {
                c++;
            }
        }
        StringBuilder strA = new StringBuilder();
        StringBuilder strB = new StringBuilder();
        StringBuilder strC = new StringBuilder();

        if (a > 0) {
            for (int i = 0; i < a; i++) {
                int index = (int) (characters.length() * Math.random());
                strA.append((characters.charAt(index)));
            }
        }

        if (b > 0) {
            for (int i = 0; i < b; i++) {
                int index = (int) (characters.length() * Math.random());
                strB.append((characters.charAt(index)));
            }
        }

        if (c > 0) {
            for (int i = 0; i < c; i++) {
                int index = (int) (digits.length() * Math.random());
                strC.append((digits.charAt(index)));
            }
        }
        String g = strA.toString() + strB.toString().toLowerCase() + strC.toString();
        return Shuffle(g);
    }

    public static String Shuffle(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());

        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    public static boolean find(String s) {
        boolean res = false;
        Matcher m = Pattern.compile("(.+)\\1+").matcher(s);
        while (m.find()) {
            res = true;
        }
        return res;
    }
}