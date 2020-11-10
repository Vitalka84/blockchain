import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
        // your implementation here
    }

    public static void main(String[] args) {
        List<String> names = List.of("Patrick Ross", "Kelly Wood", "James Moore", "Janice Coleman", "Mary Carter");
        System.out.println(names.stream()
                .filter(name -> name.length() < 12)
                .filter(name -> name.startsWith("J"))
                .count());
    }
}