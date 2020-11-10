package blockchain;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChainBlock implements Serializable {
    private static final long serialVersionUID = 1L;
    private String minerName;
    private final int id;
    private final long timestamp;
    private int magicNumber;
    private String hashPreviousBlock;
    private String hashBlock;
    private int genTime;
    private int countLeadingZeros;
    private int n;
    private List<Message> messages;
    private List<WalletTransaction> walletTransactions;
    volatile boolean isReady = false;

    public ChainBlock(int id, long timestamp, String hashPreviousBlock, List<Message> messages, List<WalletTransaction> walletTransactions, int countLeadingZeros, int n) {
        this.id = id;
        this.timestamp = timestamp;
        this.hashPreviousBlock = hashPreviousBlock;
        this.messages = new ArrayList<>(messages);
        this.walletTransactions = new ArrayList<>(walletTransactions);
        this.countLeadingZeros = countLeadingZeros;
        this.n = n;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<WalletTransaction> getWalletTransactions() {
        return walletTransactions;
    }

    public void genBlock(Person miner) {
        Random r = new Random();
        long startTimeStamp = new Date().getTime();
        StringBuffer leadingZeros = new StringBuffer();
        for (int i = 0; i < countLeadingZeros; i++) {
            leadingZeros.append("0");
        }
        String regex = leadingZeros.toString() + ".*";
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            int magicNumber = r.nextInt();
            String hash = StringUtil.applySha256(new StringBuffer(id)
                    .append(timestamp)
                    .append(magicNumber)
                    .append(messages)
                    .append(walletTransactions)
                    .append(hashPreviousBlock).toString());
            Matcher matcher = pattern.matcher(hash);
            if (matcher.matches() && this.isReady == false) {
                this.genTime = (int) (new Date().getTime() - startTimeStamp) / 1000;
                this.isReady = true;
                this.magicNumber = magicNumber;
                this.hashBlock = hash;
                this.minerName = miner == null ? "not_ready!" : miner.getName();
                if (miner != null) {
                    miner.addMoney(100);
                }
                return;
            }
            if (this.isReady) {
                return;
            }

        }

    }

    public boolean isReady() {
        return isReady;
    }

    public int getGenTime() {
        return genTime;
    }

    public int getMaxMessageIdentifier() {
        return messages.isEmpty() ? 0 : messages.stream().max(Comparator.comparingInt(Message::getIdentifier)).get().getIdentifier();
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getHashPreviousBlock() {
        return hashPreviousBlock;
    }

    public String getHashBlock() {
        return hashBlock != null ? hashBlock : "0";
    }

    public int getCountLeadingZeros() {
        return countLeadingZeros;
    }

    public boolean checkBlock() {
        return StringUtil.applySha256(new StringBuffer(this.getId())
                .append(this.getTimestamp())
                .append(this.getMagicNumber())
                .append(this.getMessages())
                .append(this.getWalletTransactions())
                .append(this.getHashPreviousBlock()).toString())
                .equals(this.getHashBlock());

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Block:");
        sb.append("\nCreated by: ").append(minerName);
        sb.append("\n").append(minerName).append(" gets 100 VC");
        sb.append("\nId: ").append(id);
        sb.append("\nTimestamp: ").append(timestamp);
        sb.append("\nMagic number: ").append(magicNumber);
        sb.append("\nHash of the previous block: \n").append(hashPreviousBlock);
        sb.append("\nHash of the block: \n").append(hashBlock);
        sb.append("\nBlock data: ");
        if (messages.size() > 0) {
            sb.append("\n");
            getMessages().stream()
                    .forEach(e -> sb.append(new StringBuffer().append(e.getAuthor() + ": " + e.getMessage() + "\n").toString()));
        }
        if (walletTransactions.size() > 0) {
            sb.append("\n");
            getWalletTransactions().stream()
                    .forEach(e -> sb.append(new StringBuffer().append(e.getSenderName()).append(" sent ").append(e.getValue())
                            .append(" VC to ")
                            .append(e.getRecipientName())
                            .append("\n")
                            .toString()));
        }
        if (messages.size() == 0 && walletTransactions.size() == 0) {
            sb.append("no messages\n");
        }
        sb.append("Block was generating for: ").append(genTime).append(" seconds");
        if (n > 0) {
            sb.append("\nN was increased to ").append(countLeadingZeros + 1).append("\n");
        } else if (n < 0) {
            sb.append("\nN was decreased by ").append(Math.abs(n)).append("\n");
        } else {
            sb.append("\nN stays the same\n");
        }
        return sb.toString();
    }
}
