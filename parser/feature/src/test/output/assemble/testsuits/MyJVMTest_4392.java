import java.io.*;
import java.nio.channels.*;
import static java.nio.file.StandardOpenOption.*;

public class MyJVMTest_4392 {

    static byte[] isParam1 = { -118, 20, -75, -54, 56, -81, -73, 110, -1, 55 };

    static int isParam2 = 670;

    static int isParam3 = 281;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    static long toSkip = 0;

    static long avail = 0;

    long skipBytes(InputStream is, long toSkip, long avail) throws IOException {
        long skip = is.skip(toSkip);
        if (skip != toSkip) {
            throw new RuntimeException("skip() returns " + skip + " but expected " + toSkip);
        }
        long remaining = avail - skip;
        int expected = (remaining >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (remaining > 0 ? (int) remaining : 0);
        System.out.println("Skipped " + skip + " bytes, available() returns " + expected + ", remaining " + remaining);
        if (is.available() != expected) {
            throw new RuntimeException("available() returns " + is.available() + " but expected " + expected);
        }
        return skip;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4392().skipBytes(is, toSkip, avail));
    }
}
