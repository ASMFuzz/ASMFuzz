import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_1676 {

    static byte[] scParam1Param1 = { 85, -104, -116, -61, -31, 125, 18, 11, 59, 2 };

    static InputStream scParam1 = new ByteArrayInputStream(scParam1Param1);

    static Scanner sc = new Scanner(scParam1);

    static int failCount = 0;

    static String text = "*}SRZL6a#L";

    static int datalen = 0;

    Scanner integerPatternBody(Scanner sc) throws Exception {
        if (sc.nextInt() != 1)
            failCount++;
        if (sc.nextShort() != 22)
            failCount++;
        if (sc.nextShort(16) != 15)
            failCount++;
        if (sc.nextShort(16) != 255)
            failCount++;
        if (sc.nextShort(36) != 35)
            failCount++;
        if (!sc.hasNextInt())
            failCount++;
        if (sc.nextInt() != -3)
            failCount++;
        if (sc.nextInt() != -44)
            failCount++;
        if (sc.nextLong() != 123)
            failCount++;
        if (!sc.hasNextInt())
            failCount++;
        if (sc.nextInt() != 1200)
            failCount++;
        if (sc.nextInt() != -123)
            failCount++;
        if (sc.nextInt() != -3400000)
            failCount++;
        try {
            sc.nextInt();
            failCount++;
        } catch (InputMismatchException ime) {
        }
        sc.next();
        try {
            sc.nextLong();
            failCount++;
        } catch (InputMismatchException ime) {
        }
        sc.next();
        try {
            sc.next();
            failCount++;
        } catch (InputMismatchException ime) {
            failCount++;
        } catch (NoSuchElementException nse) {
        }
        return sc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1676().integerPatternBody(sc);
    }
}
