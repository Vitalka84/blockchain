import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();

        Command changeChannel;
        int[] channelList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        controller.setCommand(turnOnTV);
        controller.executeCommand();
        /* write your code here */

        for (int i = 0; i < 3; i++) {
            Channel channel = new Channel(channelList[i]);
            changeChannel = new ChangeChannelCommand(channel);
            changeChannel.execute();

            /* write your code here */
        }

        Command turnOffTV = new TurnOffCommand(tv);
        controller.setCommand(turnOffTV);
        controller.executeCommand();
        /* write your code here */
    }
}

class TV {

    void turnOn() {
        System.out.println("Turning on the TV");
    }

    void turnOff() {
        System.out.println("Turning off the TV");
        /* write your code here */
    }
}

class Channel {
    private int channelNumber;

    Channel(int channelNumber) {
        this.channelNumber = channelNumber;
        /* write your code here */
    }

    void changeChannel() {
        System.out.println("Channel was changed to " + channelNumber);
    }

}

interface Command {
    void execute();
    /* write your code here */
}

class TurnOnCommand implements Command {
    private TV tv;
    /* write your code here */

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
        /* write your code here */
    }
}

class TurnOffCommand implements Command {
    private TV tv;
    /* write your code here */

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
        /* write your code here */
    }
}

class ChangeChannelCommand implements Command {
    private Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }

    /* write your code here */
}

class Controller {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
        /* write your code here */
    }
}