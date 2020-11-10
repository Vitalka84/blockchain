class Account {

    private long balance = 0;

    public synchronized boolean withdraw(long amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(long amount) {
        balance = balance + amount;
        // do something useful
    }

    public long getBalance() {
        return balance;
    }
}