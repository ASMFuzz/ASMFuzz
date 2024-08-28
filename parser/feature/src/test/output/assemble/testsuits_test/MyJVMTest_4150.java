import java.math.*;
import java.text.*;
import java.util.*;

public class MyJVMTest_4150 {

    static Number got = null;

    static String expectedParam1 = "&KP8\\l#/l{";

    static BigDecimal expected = new BigDecimal(expectedParam1);

    static int multiplier = -1130609427;

    static boolean err = false;

    Number check(Number got, BigDecimal expected, int multiplier) {
        if (!got.equals(expected)) {
            err = true;
            System.err.println("Failed: got:" + got + ", expected: " + expected + ", multiplier=" + multiplier);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4150().check(got, expected, multiplier);
    }
}
