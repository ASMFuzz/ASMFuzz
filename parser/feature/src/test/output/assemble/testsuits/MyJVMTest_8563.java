import java.math.*;
import static java.math.BigInteger.*;
import java.util.Random;

public class MyJVMTest_8563 {

    static int aParam1 = 906;

    static byte[] aParam2 = { -96, 104, -98, 29, -89, -122, -8, 8, 13, 33 };

    static BigInteger a = new BigInteger(aParam1, aParam2);

    static int bParam1 = 85;

    static long bParam2Param1 = 0;

    static Random bParam2 = new Random(bParam2Param1);

    static BigInteger b = new BigInteger(bParam1, bParam2);

    static int expected = 8;

    int compareToTest(BigInteger a, BigInteger b, int expected) {
        int result = a.compareTo(b);
        int failed = (result == expected) ? 0 : 1;
        if (failed == 1) {
            System.err.println("(" + a + ").compareTo(" + b + ") => " + result + "\n\tExpected " + expected);
        }
        return failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8563().compareToTest(a, b, expected));
    }
}
