package blockchain;

import java.io.File;

public class MessageSender extends Thread {
    Blockchain blockchain;
    Message[] messages;

    public MessageSender(Blockchain blockchain) {
        this.blockchain = blockchain;
        String privateKeyPath = "/Users/vetal/Developing/study/myTests/KeyPair/privateKey";
        String publicKeyPath = "/Users/vetal/Developing/study/myTests/KeyPair/publicKey";
        File privateKey = new File(privateKeyPath);
        File publicKey = new File(publicKeyPath);
        Person Tom = new Person("Tom", privateKey, publicKey);
        Person Sarah = new Person("Sarah", privateKey, publicKey);
        Person Nick = new Person("Nick", privateKey, publicKey);
        this.messages = new Message[]{
                SignHelper.signMessage(new Message("Hey, I'm first!", blockchain.getMessageIdentifier()), Tom),
                SignHelper.signMessage(new Message("It's not fair!", blockchain.getMessageIdentifier()), Sarah),
                SignHelper.signMessage(new Message("You always will be first because it is your blockchain!", blockchain.getMessageIdentifier()), Sarah),
                SignHelper.signMessage(new Message("Anyway, thank you for this amazing chat.", blockchain.getMessageIdentifier()), Sarah),
                SignHelper.signMessage(new Message("You're welcome :)", blockchain.getMessageIdentifier()), Tom),
                SignHelper.signMessage(new Message("Hey Tom, nice chat", blockchain.getMessageIdentifier()), Nick),
        };
    }

    @Override
    public void run() {
        for (Message sendMessage : messages) {
            blockchain.sendMessage(sendMessage);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
