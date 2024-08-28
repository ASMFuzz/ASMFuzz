import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_3934 {

    int scaledRoundedDivideTests() {
        int failures = 0;
        BigDecimal a = new BigDecimal("31415");
        BigDecimal a_minus = a.negate();
        BigDecimal b = new BigDecimal("10000");
        BigDecimal c = new BigDecimal("31425");
        BigDecimal c_minus = c.negate();
        BigDecimal d = new BigDecimal(new BigInteger("-37361671119238118911893939591735"), 10);
        BigDecimal e = new BigDecimal(new BigInteger("74723342238476237823787879183470"), 15);
        BigDecimal[][] testCases = { { a, b, BigDecimal.valueOf(ROUND_UP, 3), new BigDecimal("3.142") }, { a_minus, b, BigDecimal.valueOf(ROUND_UP, 3), new BigDecimal("-3.142") }, { a, b, BigDecimal.valueOf(ROUND_DOWN, 3), new BigDecimal("3.141") }, { a_minus, b, BigDecimal.valueOf(ROUND_DOWN, 3), new BigDecimal("-3.141") }, { a, b, BigDecimal.valueOf(ROUND_CEILING, 3), new BigDecimal("3.142") }, { a_minus, b, BigDecimal.valueOf(ROUND_CEILING, 3), new BigDecimal("-3.141") }, { a, b, BigDecimal.valueOf(ROUND_FLOOR, 3), new BigDecimal("3.141") }, { a_minus, b, BigDecimal.valueOf(ROUND_FLOOR, 3), new BigDecimal("-3.142") }, { a, b, BigDecimal.valueOf(ROUND_HALF_UP, 3), new BigDecimal("3.142") }, { a_minus, b, BigDecimal.valueOf(ROUND_HALF_UP, 3), new BigDecimal("-3.142") }, { a, b, BigDecimal.valueOf(ROUND_DOWN, 3), new BigDecimal("3.141") }, { a_minus, b, BigDecimal.valueOf(ROUND_DOWN, 3), new BigDecimal("-3.141") }, { a, b, BigDecimal.valueOf(ROUND_HALF_EVEN, 3), new BigDecimal("3.142") }, { a_minus, b, BigDecimal.valueOf(ROUND_HALF_EVEN, 3), new BigDecimal("-3.142") }, { c, b, BigDecimal.valueOf(ROUND_HALF_EVEN, 3), new BigDecimal("3.142") }, { c_minus, b, BigDecimal.valueOf(ROUND_HALF_EVEN, 3), new BigDecimal("-3.142") }, { d, e, BigDecimal.valueOf(ROUND_HALF_UP, -5), BigDecimal.valueOf(-1, -5) }, { d, e, BigDecimal.valueOf(ROUND_HALF_DOWN, -5), BigDecimal.valueOf(0, -5) }, { d, e, BigDecimal.valueOf(ROUND_HALF_EVEN, -5), BigDecimal.valueOf(0, -5) } };
        for (BigDecimal[] tc : testCases) {
            int scale = tc[2].scale();
            int rm = tc[2].unscaledValue().intValue();
            BigDecimal quotient = tc[0].divide(tc[1], scale, rm);
            if (!quotient.equals(tc[3])) {
                failures++;
                System.err.println("Unexpected quotient from " + tc[0] + " / " + tc[1] + " scale " + scale + " rounding mode " + RoundingMode.valueOf(rm) + "; expected " + tc[3] + " got " + quotient);
            }
        }
        BigDecimal[][] testCases2 = { { new BigDecimal(3090), new BigDecimal(7), new BigDecimal(441) }, { new BigDecimal("309000000000000000000000"), new BigDecimal("700000000000000000000"), new BigDecimal(441) }, { new BigDecimal("962.430000000000"), new BigDecimal("8346463.460000000000"), new BigDecimal("0.000115309916") }, { new BigDecimal("18446744073709551631"), new BigDecimal("4611686018427387909"), new BigDecimal(4) }, { new BigDecimal("18446744073709551630"), new BigDecimal("4611686018427387909"), new BigDecimal(4) }, { new BigDecimal("23058430092136939523"), new BigDecimal("4611686018427387905"), new BigDecimal(5) }, { new BigDecimal("-18446744073709551661"), new BigDecimal("-4611686018427387919"), new BigDecimal(4) }, { new BigDecimal("-18446744073709551660"), new BigDecimal("-4611686018427387919"), new BigDecimal(4) } };
        for (BigDecimal[] test : testCases2) {
            BigDecimal quo = test[0].divide(test[1], RoundingMode.HALF_UP);
            if (!quo.equals(test[2])) {
                failures++;
                System.err.println("Unexpected quotient from " + test[0] + " / " + test[1] + " rounding mode HALF_UP" + "; expected " + test[2] + " got " + quo);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3934().scaledRoundedDivideTests());
    }
}
