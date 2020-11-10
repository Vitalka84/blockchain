package blockchain;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TransactionGenerator extends Thread {
    Blockchain blockchain;
    List<Person> miners;

    public TransactionGenerator(Blockchain blockchain, List<Person> miners) {
        this.blockchain = blockchain;
        this.miners = miners;
    }

    private WalletTransaction sendRandomSum() {
        boolean isReady = false;
        WalletTransaction transaction = null;
        while (!isReady) {
            int senderIndex = new Random().nextInt(miners.size());
            int recipientIndex = new Random().nextInt(miners.size());
            double amount = ThreadLocalRandom.current().nextInt(10, 30);
            if (senderIndex != recipientIndex) {
                transaction = miners.get(senderIndex).sendMoney(amount, miners.get(recipientIndex));
            }
            if (transaction != null) {
                isReady = true;
            }
        }
        return transaction;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            blockchain.saveTransaction(sendRandomSum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
