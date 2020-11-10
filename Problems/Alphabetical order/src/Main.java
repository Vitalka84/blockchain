import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<String> input = Arrays.asList(scanner.nextLine().split("\\s"));
//        boolean res = true;
//        for (int i = 0; i < input.size() - 1; i++) {
//            if (input.get(i).compareTo(input.get(i + 1)) > 0) {
//                res = false;
//            }
//        }
//        System.out.println(res);

        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ");
        List<String> input = Arrays.asList(strArr);
        List<String> ordered = Arrays.stream(strArr).sorted(String::compareTo).collect(Collectors.toList());
        System.out.print(input.equals(ordered));
        // put your code here
    }
}