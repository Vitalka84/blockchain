class MessageNotifier extends Thread {
    final String msg;
    final int repeats;
    // write fields to store variables here

    public MessageNotifier(String msg, int repeats) {
        this.msg = msg;
        this.repeats = repeats;
        // implement the constructor
    }

    @Override
    public void run() {
        for (int i = 0; i < repeats; i++) {
            System.out.println(msg);
        }
        // implement the method to print the message stored in a field
    }
}
