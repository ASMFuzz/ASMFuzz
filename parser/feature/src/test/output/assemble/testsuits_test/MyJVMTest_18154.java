import java.math.*;
import static java.math.BigInteger.*;

public class MyJVMTest_18154 {

    static String aParam1 = "Yw61bv\"<QC";

    static int aParam2 = 621;

    static BigInteger a = new BigInteger(aParam1, aParam2);

    static String bParam1 = "SA{=gx/$,\\";

    static int bParam2 = 660;

    static BigInteger b = new BigInteger(bParam1, bParam2);

    static int expected = -1400451932;

    int compareToTest(BigInteger a, BigInteger b, int expected) {
        int result = a.compareTo(b);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println("(" + a + ").compareTo(" + b + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18154().compareToTest(a, b, expected));
    }
}
