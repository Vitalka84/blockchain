import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        String year = y + "-01-01";
        int days = scanner.nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year));
        c.add(Calendar.DATE, days - 1);  // number of days to add
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day == 1);
        // put your code here
    }
}