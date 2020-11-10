import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        for (int i = 0; i < l; i++) {
            set.add(scanner.next());
        }
        for (String el : set) {
            System.out.println(el);
        }
        // put your code here
    }
}