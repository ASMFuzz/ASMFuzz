import java.io.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_6848 {

    void newHotMethod(BigInteger bigInt2) {
        bigInt = bigInt.add(bigInt2);
    }

    static StringBuffer strBuf = null;

    static BigInteger bigInt = BigInteger.ONE;

    static int iter = 6;

    void entryNewMethod() {
        BigInteger bigInt2 = new BigInteger("100");
        for (int i = 0; i < iter; i++) newHotMethod(bigInt2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6848().entryNewMethod();
    }
}
