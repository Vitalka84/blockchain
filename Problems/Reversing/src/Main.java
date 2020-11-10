import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int res = 0;
        for (int i = input; i != 0; i /= 10) {
            res = res * 10 + i % 10;
        }
        System.out.println(res);
        // put your code here
    }
}