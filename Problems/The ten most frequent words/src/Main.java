import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = List.of(scanner.nextLine().split("\\s"));
        Map<String, Long> mapCount = list.stream()
                .map(e -> e.toLowerCase().replaceAll("[^a-z\\d]", ""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        LinkedHashMap::new
                ));
        mapToStream(mapCount).limit(10).forEach(System.out::println);
        // write your code here
    }

    private static <K, V> Stream<K> mapToStream(Map<K, V> map) {
        return map.keySet().stream();
    }
}