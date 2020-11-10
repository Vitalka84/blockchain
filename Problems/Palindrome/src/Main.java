import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String reversS = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(reversS)?"yes":"no");
        // put your code here
    }
}