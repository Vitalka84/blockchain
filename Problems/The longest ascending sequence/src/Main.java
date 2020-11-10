import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        int s1 = 1;
        int s2 = 1;
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
            if (i > 0) {
                if (array[i] > array[i - 1]) {
                    s1++;
                } else {
                    s2 = s1 > s2 ? s1 : s2;
                    s1 = 1;
                }
            }
        }
        System.out.println(s1 > s2 ? s1 : s2);
        // put your code here
    }
}