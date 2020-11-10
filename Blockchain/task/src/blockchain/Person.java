package blockchain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;

public class Person {
    private String name;
    private UUID personUUID;
    private File privateKeyFile;
    private File publicKeyFile;
    volatile double walletAmount = 0;
    private SignHelper signHelper;
    private boolean isIdentified = false;

    public Person(String name, File privateKey, File publicKey) {
        this.name = name;
        this.privateKeyFile = privateKey;
        this.publicKeyFile = publicKey;
        this.isIdentified = checkKeyPair();
        this.personUUID = UUID.randomUUID();
        this.walletAmount = 100;
    }

    public Person(String name, File publicKey) {
        this.name = name;
        this.publicKeyFile = publicKey;
        this.personUUID = UUID.randomUUID();
    }

    public Person(String name, UUID personUUID, File privateKeyFile, File publicKeyFile) {
        this.name = name;
        this.personUUID = personUUID;
        this.privateKeyFile = privateKeyFile;
        this.publicKeyFile = publicKeyFile;
    }

    public Person(String name, UUID personUUID, File publicKeyFile) {
        this.name = name;
        this.personUUID = personUUID;
        this.publicKeyFile = publicKeyFile;
    }

    public void setPrivateKeyFile(File privateKeyFile) {
        this.privateKeyFile = privateKeyFile;
        this.isIdentified = checkKeyPair();
    }

    private boolean checkKeyPair() {
        signHelper = new SignHelper(privateKeyFile, publicKeyFile);
        return signHelper.isKeyPairValid();
    }

    public String getName() {
        return isIdentified || privateKeyFile == null ? name : "user not identified";
    }

    public File getPrivateKeyFile() {
        return isIdentified ? privateKeyFile : null;
    }

    public File getPublicKeyFile() {
        return isIdentified || privateKeyFile == null ? publicKeyFile : null;
    }

    public String getPublicKey() {
        try {
            return isIdentified ? Base64.getEncoder().encodeToString(Files.readAllBytes(publicKeyFile.toPath())) : null;
        } catch (IOException e) {
            e.printStackTrace();
            return "file_read_error";
        }
    }

    public String signData(String data) {
        if (isIdentified) {
            try {
                return signHelper.sign(privateKeyFile, data);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public synchronized void addMoney(double sum) {
        this.walletAmount = walletAmount + sum;
    }

    public synchronized WalletTransaction sendMoney(double amount, Person recipient) {
        if (walletAmount >= amount) {
            WalletTransaction walletTransaction = new WalletTransaction(this.personUUID, recipient.personUUID, amount);
            this.walletAmount = walletAmount - amount;
            return SignHelper.signWalletTransaction(walletTransaction, this, recipient);
        } else {
            return null;
        }
    }

    public double getWalletAmount() {
        return walletAmount;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

}
