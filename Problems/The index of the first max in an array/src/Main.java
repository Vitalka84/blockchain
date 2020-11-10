import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int index = 0;
        int n = scanner.nextInt();
        for (int i = 1; i < l; i++) {
            int e = scanner.nextInt();
            if (e > n) {
                index = i;
                n = e;
            }
        }
        System.out.println(index);
        // put your code here
    }
}