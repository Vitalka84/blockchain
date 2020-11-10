import java.util.*;
import java.util.stream.*;

public class Main {

    private static List<LongStream> invertedStreams(List<LongStream> streams) {
        return streams.stream()
                .parallel()
                .map(e -> e.isParallel() ? e.sequential() : e.parallel())
                .collect(Collectors.toList());
    }

    /* Do not modify the code below */
    public static void main(String[] args) {
        IntStream.iterate(10, (n) -> n + 1).limit(3).forEach(System.out::println);    }
}