package blockchain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Blockchain {

    private File fileForSave;
    private List<ChainBlock> blockList = new ArrayList<>();
    private int countLeadingZeros = 2;
    private int n = 0;
    private int i = 0;
    private long timeStamp;
    private ChainBlock lastAddedBlock;
    private List<Message> messages;
    private List<WalletTransaction> walletTransactions;
    private int messageIdentifier = 0;
    private SignHelper signHelper = new SignHelper();

    public Blockchain(String filePath, boolean isNew) throws IOException {
        this.messages = new ArrayList<>();
        this.walletTransactions = new ArrayList<>();
        setFileForSave(filePath, isNew);
    }

    public synchronized void addBlock(ChainBlock block) {
        try {
            SerializationUtils.serialize(block, fileForSave.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMessageIdentifier() {
        return ++messageIdentifier;
    }

    public ChainBlock getBlockForMining() {
        if (lastAddedBlock.isReady) {
            timeStamp = new Date().getTime();
            lastAddedBlock = new ChainBlock(++i, timeStamp, getPrevBlockHash(), messages, walletTransactions, getCountLeadingZeros(), n);
            messages.clear();
            walletTransactions.clear();
        }
        return lastAddedBlock;
    }

    private int getCountLeadingZeros() {
        if (lastAddedBlock.getGenTime() < 10 && countLeadingZeros < 5) {
            n = 1;
            return ++countLeadingZeros;
        } else if (lastAddedBlock.getGenTime() > 13 && countLeadingZeros > 0) {
            n = -1;
            return --countLeadingZeros;
        } else {
            n = 0;
            return countLeadingZeros;
        }
    }

    public static boolean checkBlockChain(List<ChainBlock> blockChain) {
        for (int i = 0; i < blockChain.size(); i++) {
            if (i == 0 && blockChain.get(i).getId() == 1 && !blockChain.get(i).getHashPreviousBlock().equals("0")) {
                return false;
            }
            if (i > 0 && blockChain.get(i).getHashPreviousBlock() != blockChain.get(i - 1).getHashBlock()) {
                return false;
            }
        }
        return true;
    }

    private String getPrevBlockHash() {
        return lastAddedBlock.getHashBlock();
    }

    public synchronized void sendMessage(Message message) {
        int maxSavedMessageIdentifier = 0;
        if (!messages.isEmpty()) {
            maxSavedMessageIdentifier = messages.stream().max(Comparator.comparingInt(Message::getIdentifier)).get().getIdentifier();
        }
        if (message.getIdentifier() > maxSavedMessageIdentifier) {
            try {
                if (signHelper.verifyMessageSignature(message)) {
                    this.messages.add(message);
                }
            } catch (Exception e) {
                System.out.println("Signature not valid!");
                e.printStackTrace();
            }
        } else {
            System.out.println("Error saving message. Bad identifier!");
        }
    }

    public synchronized void saveTransaction(WalletTransaction transaction) {
        this.walletTransactions.add(transaction);
    }

    public List<ChainBlock> getBlockList() throws IOException, ClassNotFoundException {
        return readFromFile(fileForSave);
    }

    private void setFileForSave(String fileName, boolean isNew) throws IOException {

        this.fileForSave = new File(fileName);
        File parent = fileForSave.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        if (fileForSave.exists() && fileForSave.length() != 0) {
            if (isNew) {
                long curTime = new Date().getTime();
                try {
                    String arcDir = fileForSave.getParent() + "/arch/";
                    Files.createDirectories(Paths.get(arcDir));
                    Files.copy(fileForSave.toPath(),
                            (new File(arcDir + curTime + "_" + fileForSave.getName()).toPath()),
                            StandardCopyOption.REPLACE_EXISTING);
                    PrintWriter writer = new PrintWriter(fileForSave);
                    writer.print("");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                fileForSave.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            blockList = readFromFile(fileForSave);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        if (blockList.size() == 0) {
            this.timeStamp = new Date().getTime();
            lastAddedBlock = new ChainBlock(++i, timeStamp, "0", messages, walletTransactions, countLeadingZeros, 0);
            blockList.add(lastAddedBlock);
            SerializationUtils.serialize(lastAddedBlock, fileForSave.getAbsolutePath());
        }
        lastAddedBlock = blockList.get(blockList.size() - 1);
    }

    private List<ChainBlock> readFromFile(File fileForSave) throws ClassNotFoundException, IOException {
        List<ChainBlock> res = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileForSave);
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                ChainBlock newBlock = (ChainBlock) ois.readObject();
                this.i = newBlock.getId();
                this.countLeadingZeros = newBlock.getCountLeadingZeros();
                this.messageIdentifier = newBlock.getMaxMessageIdentifier();
                res.add(newBlock);
            }
        } catch (IOException ignored) {
            // as expected
        } finally {
            if (fis != null)
                fis.close();
        }
        return res;
    }

}
