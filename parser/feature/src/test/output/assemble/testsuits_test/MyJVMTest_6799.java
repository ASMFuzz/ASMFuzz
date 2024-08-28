import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_6799 {

    static byte[] b = { -105, -56, -105, 72, 103, -51, -51, -113, 121, 86 };

    static int off = -1917758101;

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    int get16(byte[] b, int off) {
        return (b[off] & 0xff) | ((b[off + 1] & 0xff) << 8);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6799().get16(b, off));
    }
}
