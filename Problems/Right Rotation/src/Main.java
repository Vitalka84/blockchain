import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer strToken = new StringTokenizer(scanner.nextLine());
        int rotations = scanner.nextInt();
        int count = strToken.countTokens();

        int[] arr = new int[count];
        for (int x = 0; x < count; x++) {
            arr[x] = Integer.parseInt((String) strToken.nextElement());
        }
        int a = rotations / count;
        int r = rotations - a * count;
        int[] resArr = new int[count];
        for (int x = 0; x < count; x++) {
            int index = x + r;
            if (index > count - 1) {
                index = index - count;
            }
            resArr[index] = arr[x];
        }
        for (int i : resArr) {
            System.out.print(i + " ");
        }
        // put your code here
    }
}