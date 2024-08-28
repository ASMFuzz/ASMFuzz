import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.lang.Double.*;

public class MyJVMTest_9763 {

    static double expected = Double.NEGATIVE_INFINITY;

    static double computed = Double.MAX_VALUE;

    static double threshold = 0d;

    int compareUlpDifference(double expected, double computed, double threshold) {
        if (!Double.isFinite(expected)) {
            if (Double.compare(expected, computed) == 0)
                return 0;
            else {
                System.err.printf("Unexpected sum, %g rather than %g.%n", computed, expected);
                return 1;
            }
        }
        double ulpDifference = Math.abs(expected - computed) / Math.ulp(expected);
        if (ulpDifference > threshold) {
            System.err.printf("Numerical summation error too large, %g ulps rather than %g.%n", ulpDifference, threshold);
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9763().compareUlpDifference(expected, computed, threshold));
    }
}
