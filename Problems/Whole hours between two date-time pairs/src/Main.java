import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        long date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(scanner.nextLine()).getTime();
        long date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(scanner.nextLine()).getTime();
        long res = (date2 - date1) / 3_600_000;
        System.out.println(res);
        // put your code here
    }
}