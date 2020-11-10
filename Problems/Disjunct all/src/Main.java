import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

class CombiningPredicates {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        IntPredicate f = n -> false;
        for (IntPredicate predicate : predicates) {
            f = f.or(predicate);
        }
        return f; // write your code here
    }

    // Don't change the code below
    public static void main(String[] args) {

        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> { int v = val * 2; };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(100);
    }
}