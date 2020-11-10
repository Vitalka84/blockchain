class Starter {

    public static void startRunnables(Runnable[] runnables) {
        for (Runnable runnable : runnables) {
            Thread instance = new Thread(runnable);
            instance.start();
        }
        // implement the method
    }
}