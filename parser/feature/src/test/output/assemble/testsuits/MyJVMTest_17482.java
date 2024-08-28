import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_17482 {

    int divideByOneTests() {
        int failures = 0;
        BigDecimal one = BigDecimal.ONE.setScale(17);
        RoundingMode rounding = RoundingMode.UNNECESSARY;
        long[][] unscaledAndScale = new long[][] { { Long.MAX_VALUE, 17 }, { -Long.MAX_VALUE, 17 }, { Long.MAX_VALUE, 0 }, { -Long.MAX_VALUE, 0 }, { Long.MAX_VALUE, 100 }, { -Long.MAX_VALUE, 100 } };
        for (long[] uas : unscaledAndScale) {
            long unscaled = uas[0];
            int scale = (int) uas[1];
            BigDecimal noRound = null;
            try {
                noRound = BigDecimal.valueOf(unscaled, scale).divide(one, RoundingMode.UNNECESSARY);
            } catch (ArithmeticException e) {
                failures++;
                System.err.println("ArithmeticException for value " + unscaled + " and scale " + scale + " without rounding");
            }
            BigDecimal roundDown = null;
            try {
                roundDown = BigDecimal.valueOf(unscaled, scale).divide(one, RoundingMode.DOWN);
            } catch (ArithmeticException e) {
                failures++;
                System.err.println("ArithmeticException for value " + unscaled + " and scale " + scale + " with rounding down");
            }
            if (noRound != null && roundDown != null && noRound.compareTo(roundDown) != 0) {
                failures++;
                System.err.println("Equality failure for value " + unscaled + " and scale " + scale);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17482().divideByOneTests());
    }
}
