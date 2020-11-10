import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        LocalDate start = LocalDate.parse(year + "-01-01");
        LocalDate date1 = start.plusDays(scanner.nextInt() - 1);
        LocalDate date2 = start.plusDays(scanner.nextInt() - 1);
        LocalDate date3 = start.plusDays(scanner.nextInt() - 1);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

        // put your code here
    }
}