package blockchain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class WalletTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private final UUID senderUUID;
    private final UUID recipientUUID;
    private final UUID transactionUUID;
    private String senderName;
    private String recipientName;
    private final double value;
    private String signature;
    private String publicKey;
    private final LocalDate date;

    public WalletTransaction(UUID senderUUID, UUID recipientUUID, double value, String signature) {
        this.senderUUID = senderUUID;
        this.recipientUUID = recipientUUID;
        this.value = value;
        this.signature = signature;
        this.transactionUUID = UUID.randomUUID();
        this.date = LocalDate.now();
    }

    public WalletTransaction(UUID senderUUID, UUID recipientUUID, double value) {
        this.senderUUID = senderUUID;
        this.recipientUUID = recipientUUID;
        this.transactionUUID = UUID.randomUUID();;
        this.value = value;
        this.date = LocalDate.now();
    }

    public String getDataForSign() {
        return new StringBuffer()
                .append(date).append("+")
                .append(senderUUID).append("+")
                .append(recipientUUID).append("+")
                .append(transactionUUID).append("+")
                .append(value).append("+")
                .toString();
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getSenderUUID() {
        return senderUUID;
    }

    public UUID getRecipientUUID() {
        return recipientUUID;
    }

    public UUID getTransactionUUID() {
        return transactionUUID;
    }

    public double getValue() {
        return value;
    }

    public String getSignature() {
        return signature;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
