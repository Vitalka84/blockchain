package blockchain;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String author;
    private String message;
    private String signature;
    private String publicKey;
    private int identifier;

    public Message(String author, String message, String signature, String publicKey, int identifier) {
        this.author = author;
        this.message = message;
        this.signature = signature;
        this.publicKey = publicKey;
        this.identifier = identifier;
    }

    public Message(String message, int identifier) {
        this.message = message;
        this.identifier = identifier;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getSignature() {
        return signature;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public String getDataForSign() {
        return new StringBuffer().append(identifier).append(message).toString();
    }
}
