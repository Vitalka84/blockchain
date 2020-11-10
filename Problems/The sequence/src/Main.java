import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = 1;
        int check = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(start + " ");
            if (start == check) {
                start++;
                check = 1;
            } else {
                check++;
            }
        }
        // put your code here
    }
}