import java.util.ArrayList;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Stream.concat;

class FunctionUtils {

    public static <T> Supplier<Stream<T>> saveStream(Stream<T> src) {
        final Spliterator<T> iter = src.spliterator();
        final ArrayList<T> arrayList = new ArrayList<>();
        class StreamSaver extends Spliterators.AbstractSpliterator<T> {
            StreamSaver() {
                super(iter.estimateSize(), iter.characteristics());
            }

            public boolean tryAdvance(Consumer<? super T> action) {
                return iter.tryAdvance(i -> {
                    arrayList.add(i);
                    action.accept(i);
                });
            }
        }
        StreamSaver streamSaver = new StreamSaver();
        return () -> concat(arrayList.stream(), StreamSupport.stream(streamSaver, false));
        // write your code here
    }

}