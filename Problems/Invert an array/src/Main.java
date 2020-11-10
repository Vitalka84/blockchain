// do not remove imports

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

class ArrayUtils {
    static <T> T[] invert(T[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;
    }
    // define invert method here
}