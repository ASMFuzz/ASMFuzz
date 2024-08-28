import java.math.BigInteger;
import java.util.function.Supplier;

public class MyJVMTest_7771 {

    static Supplier<BigInteger> s = null;

    Supplier<BigInteger> test(Supplier<BigInteger> s) {
        try {
            BigInteger x = s.get();
            System.out.println("Surprisingly passed with correct bitLength() " + x.bitLength());
        } catch (ArithmeticException e) {
            System.out.println("Overflow reported by ArithmeticException, as expected");
        } catch (OutOfMemoryError e) {
            System.err.println("BitLengthOverflow skipped: OutOfMemoryError");
            System.err.println("Run jtreg with -javaoption:-Xmx8g");
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7771().test(s);
    }
}
