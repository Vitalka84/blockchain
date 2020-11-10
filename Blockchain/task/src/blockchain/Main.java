package blockchain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "/Users/vetal/Developing/study/data_for_dev/blockchain.dat";
        String privateKeyPath = "/Users/vetal/Developing/study/myTests/KeyPair/privateKey";
        String publicKeyPath = "/Users/vetal/Developing/study/myTests/KeyPair/publicKey";
        File privateKey = new File(privateKeyPath);
        File publicKey = new File(publicKeyPath);

        List<Person> miners = new ArrayList<>();
        miners.add(new Person("Tom", privateKey, publicKey));
        miners.add(new Person("Sarah", privateKey, publicKey));
        miners.add(new Person("Nick", privateKey, publicKey));
        miners.add(new Person("FastFood", privateKey, publicKey));
        miners.add(new Person("ShoesShop", privateKey, publicKey));
        miners.add(new Person("Alice", privateKey, publicKey));
        miners.add(new Person("Bob", privateKey, publicKey));

        int poolSize = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        boolean isNew = true;
        Blockchain blockchain;
        blockchain = new Blockchain(filePath, isNew);
//        Thread sm = new MessageSender(blockchain);
//        sm.start();
        Thread tg = new TransactionGenerator(blockchain, miners);
        tg.start();
        for (int i = 0; i < 15; i++) {

            ChainBlock newBlock = blockchain.getBlockForMining();
            Runnable task = () -> {
                try {
                    Thread.sleep(500);
                    newBlock.genBlock(miners.get(new Random().nextInt(miners.size())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            for (int j = 0; j < poolSize; j++) {
                executor.submit(task);
            }
            int isAdded = 0;
            while (isAdded != 1) {
                if (newBlock.isReady()) {
                    blockchain.addBlock(newBlock);
                    isAdded = 1;
                    System.out.println(newBlock.toString());
                }
            }
        }
//        miners.stream().forEach(e -> System.out.println(e.getName() + ": " + e.getWalletAmount()));
        executor.shutdown();
    }

}
