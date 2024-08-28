import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_1087 {

    static ReadableByteChannel scParam1 = null;

    static Scanner sc = new Scanner(scParam1);

    static int failCount = 0;

    static String text = "i%LRs9gAA4";

    static int datalen = 7;

    Scanner floatPatternBody(Scanner sc) throws Exception {
        if (sc.nextFloat() != 090.090f)
            failCount++;
        if (sc.nextFloat() != 1f)
            failCount++;
        if (sc.nextFloat() != 22.0f)
            failCount++;
        if (sc.nextDouble() != -3d)
            failCount++;
        if (sc.nextDouble() != -44.05d)
            failCount++;
        if (sc.nextFloat() != .123f)
            failCount++;
        if (sc.nextFloat() != -.1234f)
            failCount++;
        if (sc.nextDouble() != -3400000d)
            failCount++;
        if (sc.nextDouble() != 56566.6d)
            failCount++;
        if (sc.nextDouble() != Double.POSITIVE_INFINITY)
            failCount++;
        if (sc.nextDouble() != Double.POSITIVE_INFINITY)
            failCount++;
        if (sc.nextDouble() != Double.NEGATIVE_INFINITY)
            failCount++;
        if (!Double.valueOf(sc.nextDouble()).isNaN())
            failCount++;
        if (!Double.valueOf(sc.nextDouble()).isNaN())
            failCount++;
        if (!Double.valueOf(sc.nextDouble()).isNaN())
            failCount++;
        try {
            sc.nextFloat();
            failCount++;
        } catch (NoSuchElementException nse) {
        }
        try {
            sc.nextDouble();
            failCount++;
        } catch (NoSuchElementException nse) {
        }
        try {
            sc.nextDouble();
            failCount++;
        } catch (NoSuchElementException nse) {
        }
        return sc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1087().floatPatternBody(sc);
    }
}
