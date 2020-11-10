import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = 1;
        long f = 0;
        while (m >= n) {
            f++;
            n = n * f;
        }
        System.out.println(f);
        // put your code here
    }
}