package blockchain;

import java.util.concurrent.ThreadLocalRandom;

public class TestDrive {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            double random = ThreadLocalRandom.current().nextInt(10, 30);
            System.out.println(random);
        }

    }
}
