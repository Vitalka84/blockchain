import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int offset = scanner.nextInt();
//        if (offset == 1) {
//            offset = 0;
//        }
        LocalDate initial = LocalDate.of(year, month, 1);
        LocalDate endDate = initial.withDayOfMonth(initial.lengthOfMonth());
        LocalDate res = endDate.minusDays(offset - 1);
        System.out.println(res.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        // put your code here
    }
}