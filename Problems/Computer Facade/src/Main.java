class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();
        /* Your subsystems */

        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    private Processor processor;
    private Monitor monitor;
    private Keyboard keyboard;
    /* Your subsystems */

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        processor.on();
        monitor.on();
        keyboard.on();
        /* Write your code here */
    }

    public void turnOffComputer() {
        keyboard.off();
        monitor.off();
        processor.off();
        /* Write your code here */
    }
}

class Processor {
    private String description;

    public Processor() {
        this.description = "Processor";
    }
    /* Your subsystem description */

    public void on() {
        System.out.println(description + " on");
        /* Write your code here */
    }

    public void off() {
        System.out.println(description + " off");
        /* Write your code here */
    }
}

class Monitor {
    private String description;
    /* Your subsystem description */

    public Monitor() {
        this.description = "Monitor";
    }

    public void on() {
        System.out.println(description + " on");
        /* Write your code here */
    }

    public void off() {
        System.out.println(description + " off");
        /* Write your code here */
    }
}

class Keyboard {
    private String description;
    /* Your subsystem description */

    public Keyboard() {
        this.description = "Keyboard";
    }

    public void on() {
        System.out.println(description + " on");
        turnOnBacklight();
        /* Write your code here */
    }

    public void off() {
        System.out.println(description + " off");
        turnOffBacklight();
        /* Write your code here */
    }

    private void turnOnBacklight() {
        System.out.println("Backlight is turned on");
        /* Write your code here */
    }

    private void turnOffBacklight() {
        System.out.println("Backlight is turned off");
        /* Write your code here */
    }
}