package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

    /**
     * return i ^ n for positive Integer, None otherwise
     * alse return None in case of errors
     */

    public static Option<Integer> power(Integer i, Integer n) {
        try {
            var value = calculatePower(i, n);
            return Option.of(value);
        } catch (Exception | StackOverflowError e) {
            return Option.none();
        }
    }

    private static Integer calculatePower(Integer num, int pow) throws Exception, StackOverflowError {
        if (pow == 0)
            return 1;
        else
            return num * calculatePower(num, pow - 1);
    }
}
