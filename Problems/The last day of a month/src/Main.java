import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate localDate = LocalDate.ofYearDay(year, day);
        System.out.println(localDate.getDayOfMonth() == localDate.lengthOfMonth());
        // put your code here
    }
}