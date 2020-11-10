class ClassCountingInstances {

    private static long numberOfInstances;

    public ClassCountingInstances() {
        synchronized (ClassCountingInstances.class) {
            this.numberOfInstances = this.getNumberOfInstances() + 1;
        }

        // write the increment here
    }

    public static synchronized long getNumberOfInstances() {
        return numberOfInstances;
    }
}