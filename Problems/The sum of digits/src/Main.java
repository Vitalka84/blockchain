import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int sum = 0;
        while (input != 0) {
            sum = sum + input % 10;
            input = input / 10;
        }
        System.out.println(sum);
        // put your code here
    }
}