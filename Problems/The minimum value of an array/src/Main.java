import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int item;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            item = scanner.nextInt();
            if (item < res) {
                res = item;
            }
        }
        System.out.println(res);
        // put your code here
    }
}