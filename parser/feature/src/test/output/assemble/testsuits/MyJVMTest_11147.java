import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_11147 {

    int nonTerminating() {
        int failures = 0;
        int[] primes = { 1, 3, 7, 13, 17 };
        for (int i = 0; i < primes.length; i++) {
            for (int j = i + 1; j < primes.length; j++) {
                for (int m = 0; m < primes.length; m++) {
                    for (int n = m + 1; n < primes.length; n++) {
                        int dividend = primes[i] * primes[j];
                        int divisor = primes[m] * primes[n];
                        if (((dividend / divisor) * divisor) != dividend) {
                            try {
                                BigDecimal quotient = (new BigDecimal(dividend).divide(new BigDecimal(divisor)));
                                failures++;
                                System.err.println("Exact quotient " + quotient.toString() + " returned for non-terminating fraction " + dividend + " / " + divisor + ".");
                            } catch (ArithmeticException e) {
                                ;
                            }
                        }
                    }
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11147().nonTerminating());
    }
}
