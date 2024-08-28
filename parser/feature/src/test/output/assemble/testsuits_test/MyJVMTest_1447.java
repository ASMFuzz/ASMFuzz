import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_1447 {

    static int dividendParam1 = 122;

    static BigDecimal dividend = new BigDecimal(dividendParam1);

    static double divisorParam1 = 0.010387609885341043;

    static String divisorParam2Param1 = "onEz+c/y]>";

    static MathContext divisorParam2 = new MathContext(divisorParam2Param1);

    static BigDecimal divisor = new BigDecimal(divisorParam1, divisorParam2);

    BigDecimal anotherDivide(BigDecimal dividend, BigDecimal divisor) {
        if (divisor.signum() == 0) {
            if (dividend.signum() == 0)
                throw new ArithmeticException("Division undefined");
            throw new ArithmeticException("Division by zero");
        }
        if (dividend.signum() == 0)
            return BigDecimal.ZERO;
        else {
            BigInteger TWO = BigInteger.valueOf(2);
            BigInteger FIVE = BigInteger.valueOf(5);
            BigInteger TEN = BigInteger.valueOf(10);
            BigInteger divisorIntvalue = divisor.scaleByPowerOfTen(divisor.scale()).toBigInteger().abs();
            BigInteger dividendIntvalue = dividend.scaleByPowerOfTen(dividend.scale()).toBigInteger().abs();
            BigInteger b_prime = divisorIntvalue.divide(dividendIntvalue.gcd(divisorIntvalue));
            boolean goodDivisor = false;
            int i = 0, j = 0;
            badDivisor: {
                while (!b_prime.equals(BigInteger.ONE)) {
                    int b_primeModTen = b_prime.mod(TEN).intValue();
                    switch(b_primeModTen) {
                        case 0:
                            i++;
                            j++;
                            b_prime = b_prime.divide(TEN);
                            break;
                        case 5:
                            j++;
                            b_prime = b_prime.divide(FIVE);
                            break;
                        case 2:
                        case 4:
                        case 6:
                        case 8:
                            i++;
                            b_prime = b_prime.divide(TWO);
                            break;
                        default:
                            b_prime = BigInteger.ONE;
                            break badDivisor;
                    }
                }
                goodDivisor = true;
            }
            if (!goodDivisor) {
                throw new ArithmeticException("Non terminating decimal expansion");
            } else {
                MathContext mc = new MathContext(dividend.precision() + (int) Math.ceil(10.0 * divisor.precision() / 3.0), RoundingMode.UNNECESSARY);
                return dividend.divide(divisor, mc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1447().anotherDivide(dividend, divisor));
    }
}
