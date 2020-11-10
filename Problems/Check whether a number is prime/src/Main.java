import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newSingleThreadExecutor(); // assign an object to it

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            try {
                executor.submit(() -> {
                    new PrintIfPrimeTask(number).run();
                });
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            // create and submit tasks
        }
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (isPrime(number)) {
            System.out.println(number);
        }
        // write code of task here
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}