//put imports you need here

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = new ArrayList<>();
        String str;
        for (int i = 0; i < 4; i++) {
            str = scanner.nextLine();
            String[] splited = str.split("\\s+");
            guests.addAll(Arrays.asList(splited));
        }
        for (int i = guests.size()-1; i >= 0; i--) {
            System.out.println(guests.get(i));
        }
        // put your code here
    }
}