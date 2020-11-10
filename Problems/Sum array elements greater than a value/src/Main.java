import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int[] arr = new int[l];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                res = res + arr[i];
            }
        }
        System.out.println(res);
        // put your code here
    }
}