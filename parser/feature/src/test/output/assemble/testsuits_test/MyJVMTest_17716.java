import java.io.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_17716 {

    static int bigInt2Param1 = 464;

    static Random bigInt2Param2 = new Random();

    static BigInteger bigInt2 = new BigInteger(bigInt2Param1, bigInt2Param2);

    static StringBuffer strBuf = null;

    static BigInteger bigInt = BigInteger.ONE;

    static int iter = -268956617;

    BigInteger newHotMethod(BigInteger bigInt2) {
        bigInt = bigInt.add(bigInt2);
        return bigInt2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17716().newHotMethod(bigInt2);
    }
}
