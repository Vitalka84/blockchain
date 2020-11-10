import java.util.function.LongBinaryOperator;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        for (long i = x + 1; i <= y; i++) {
            x = x * i;
        }
        return x;
    }; // Write your code here
}