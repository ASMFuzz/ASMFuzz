import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_9863 {

    static byte[] b = { -74, -5, 23, 47, -89, 14, -63, 113, -20, 100 };

    static int off = 0;

    static int value = 2;

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    int set16(byte[] b, int off, int value) {
        b[off + 0] = (byte) value;
        b[off + 1] = (byte) (value >> 8);
        return off;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9863().set16(b, off, value);
    }
}
