import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        final String OLD_FORMAT = "yyyy-MM-dd";
        final String NEW_FORMAT = "MM/dd/yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = sdf.parse(input);
        sdf.applyPattern(NEW_FORMAT);
        System.out.println(sdf.format(d));

        // put your code here
    }
}