import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_10282 {

    static byte[] scParam1Param1 = { -122, -69, 104, 110, 48, 70, 102, -80, 59, -67 };

    static InputStream scParam1 = new ByteArrayInputStream(scParam1Param1);

    static Scanner sc = new Scanner(scParam1);

    static int failCount = 0;

    static String text = "ReE2yr6BJI";

    static int datalen = 0;

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
        new MyJVMTest_10282().floatPatternBody(sc);
    }
}
