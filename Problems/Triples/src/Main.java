import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        int res = 0;
        int checkN = -1;
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
            if (i > 0) {
                if (array[i - 1] + 1 == array[i]) {
                    checkN++;
                    if (checkN > 0) {
                        res++;
                    }
                } else {
                    checkN = -1;
                }
            }
        }
        System.out.println(res);
        // put your code here
    }
}