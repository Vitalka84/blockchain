import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int[] array = new int[l];
        for (int i = 0; i < l; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        System.out.println(Arrays.stream(array).filter(e -> e == n).count());
        // put your code here
    }
}