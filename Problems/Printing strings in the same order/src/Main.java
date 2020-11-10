import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(scanner.next());
        }
        for (String s : l) {
            System.out.println(s);
        }
        // put your code here
    }
}