class CalculatorCreator {

    public static Calculator createInstance() {

        Calculator anonymousCalculator = new Calculator() {
            @java.lang.Override
            public long sum(long val1, long val2) {
                return val1 + val2;
            }

            @java.lang.Override
            public long subtraction(long val1, long val2) {
                return val1 - val2;
            }
        };/* create an instance of an anonymous class here,
                                            do not forget ; in the end */
        return anonymousCalculator;
    }

}

abstract class Calculator {

    public abstract long sum(long val1, long val2);

    public abstract long subtraction(long val1, long val2);
}