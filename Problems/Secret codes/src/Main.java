import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<String> extractCodes(List<String> codes) {
        return codes.stream()
                .dropWhile(e -> !"#0000".equals(e))
                .takeWhile(e -> !"#FFFF".equals(e))
                .skip(1)
                .collect(Collectors.toList());
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 5, 4, 8, 9, 2);
        numbers.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println("");
        numbers.parallelStream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println("");
        numbers.stream().sorted().parallel().forEach(e -> System.out.print(e + " "));
        System.out.println("");
        numbers.parallelStream().sorted().forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
        numbers.parallelStream().sorted().sequential().forEach(e -> System.out.print(e + " "));
    }
}