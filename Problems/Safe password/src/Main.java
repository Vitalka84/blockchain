import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String pasRegs = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{12,}$";
        Pattern pattern = Pattern.compile(pasRegs);
        System.out.println(pattern.matcher(password).matches() ? "YES" : "NO");

        // write your code here
    }
}