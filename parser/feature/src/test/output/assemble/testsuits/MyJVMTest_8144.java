import java.io.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_8144 {

    static String bigInt2Param1 = "aV*r%s!j6=";

    static BigInteger bigInt2 = new BigInteger(bigInt2Param1);

    static StringBuffer strBuf = null;

    static BigInteger bigInt = BigInteger.ONE;

    static int iter = 0;

    BigInteger newHotMethod(BigInteger bigInt2) {
        bigInt = bigInt.add(bigInt2);
        return bigInt2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8144().newHotMethod(bigInt2);
    }
}
