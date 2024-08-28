import java.io.*;
import java.nio.channels.*;
import static java.nio.file.StandardOpenOption.*;

public class MyJVMTest_13767 {

    static byte[] isParam1 = { 34, -94, -81, -15, 31, 71, -20, -65, -2, -86 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    static long toSkip = 4016049225465601418L;

    static long avail = -9223372036854775808L;

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
        System.out.println(new MyJVMTest_13767().skipBytes(is, toSkip, avail));
    }
}
