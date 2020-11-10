package blockchain;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignHelper {

    private File privateKeyFile;
    private File publicKeyFile;
    private String testData;

    public SignHelper(File privateKey, File publicKey) {
        this.privateKeyFile = privateKey;
        this.publicKeyFile = publicKey;
        this.testData = "test";
    }

    public SignHelper() {
    }

    private PrivateKey getPrivate(File privateKeyFile) throws Exception {
        byte[] keyBytes = Files.readAllBytes(privateKeyFile.toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public byte[] sign(PrivateKey privateKey, String data) throws InvalidKeyException, Exception {
        Signature rsa = Signature.getInstance("SHA1withRSA");
        rsa.initSign(privateKey);
        rsa.update(data.getBytes());
        return rsa.sign();
    }

    public String sign(File privateKeyFile, String data) throws InvalidKeyException, Exception {
        Signature rsa = Signature.getInstance("SHA1withRSA");
        rsa.initSign(getPrivate(privateKeyFile));
        rsa.update(data.getBytes());
        return Base64.getEncoder().encodeToString(rsa.sign());
    }

    public boolean verifySignature(String data, String signature) throws Exception {
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(getPublic());
        sig.update(data.getBytes(StandardCharsets.UTF_8));
        return sig.verify(Base64.getDecoder().decode(signature));
    }

    private PublicKey getPublic() throws Exception {
        byte[] keyBytes = Files.readAllBytes(publicKeyFile.toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    private PublicKey getPublic(String publicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public boolean isKeyPairValid() {
        if (privateKeyFile != null && publicKeyFile != null) {
            try {
                String sign = sign(privateKeyFile, testData);
                return verifySignature(testData, sign);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public void setPrivateKeyFile(File privateKeyFile) {
        this.privateKeyFile = privateKeyFile;
    }

    public static Message signMessage(Message message, Person signer) {
        String signature = signer.signData(message.getDataForSign());
        message.setSignature(signature);
        message.setPublicKey(signer.getPublicKey());
        message.setAuthor(signer.getName());
        return message;
    }

    public boolean verifyMessageSignature(Message message) throws Exception {
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(getPublic(message.getPublicKey()));
        sig.update(message.getDataForSign().getBytes(StandardCharsets.UTF_8));
        return sig.verify(Base64.getDecoder().decode(message.getSignature()));
    }

    public static WalletTransaction signWalletTransaction(WalletTransaction transaction, Person sender, Person recipient) {
        String signature = sender.signData(transaction.getDataForSign());
        transaction.setSignature(signature);
        transaction.setPublicKey(sender.getPublicKey());
        transaction.setSenderName(sender.getName());
        transaction.setRecipientName(recipient.getName());
        return transaction;
    }
}
