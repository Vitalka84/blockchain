import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long seconds = scanner.nextLong();
        LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
        System.out.println(timeOfDay.toString());
        // put your code here
    }
}