import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

class PrimeNumbers {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        return LongStream.range(2, number + 1)
                .boxed()
                .filter(n -> n <= number / 2 && number % n == 0)
                .count() == 0 ? true : false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();

        int n = Integer.parseInt(line);

        System.out.println(isPrime(n) ? "True" : "False");
    }
}