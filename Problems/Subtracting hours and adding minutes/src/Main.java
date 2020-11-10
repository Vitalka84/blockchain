import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter);
        long subHours = scanner.nextLong();
        long addMinutes = scanner.nextLong();
        System.out.println(dateTime.plusMinutes(addMinutes).minusHours(subHours));
        // put your code here
    }
}