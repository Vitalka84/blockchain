import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        int n;
        do {
            n = scanner.nextInt();
            res = res + n;
        } while (n != 0);
        System.out.println(res);
        // put your code here
    }
}