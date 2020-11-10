import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(gcd(3, 6));
//    is 3+

        System.out.println(gcd(1, 1));
//        is 1+

        System.out.println(gcd(1, 3));
//        is 3-

        System.out.println(gcd(4, 6));
//        is 2+

        System.out.println(gcd(6, 2));
//        is 3-

        System.out.println(gcd(3, 7));
//        is 7-
        // call the method here
    }
    public static int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    // Do not change code below   
    public static void countAreaOfParallelogram(int b, int h) {
        System.out.println(b * h);
    }
}