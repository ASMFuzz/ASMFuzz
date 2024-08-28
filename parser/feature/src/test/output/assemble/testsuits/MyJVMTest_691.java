import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_691 {

    static byte[] b = { 91, 74, 77, 80, 52, 74, -20, -10, -52, -18 };

    static int off = 913925800;

    static int value = 0;

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    int set16(byte[] b, int off, int value) {
        b[off + 0] = (byte) value;
        b[off + 1] = (byte) (value >> 8);
        return off;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_691().set16(b, off, value);
    }
}
