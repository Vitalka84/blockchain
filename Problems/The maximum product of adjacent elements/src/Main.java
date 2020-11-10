import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int[] array = new int[l];
        int res = 0;
        for (int i = 0; i < l; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                res = array[i] * array[i + 1] > res ? array[i] * array[i + 1] : res;
            }
        }
        System.out.println(res);
        // put your code here
    }
}