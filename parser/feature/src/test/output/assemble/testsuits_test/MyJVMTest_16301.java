import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_16301 {

    static byte[] b = { -82, -122, -121, -27, -94, 9, -57, -100, -72, -42 };

    static int off = 7;

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    int get16(byte[] b, int off) {
        return (b[off] & 0xff) | ((b[off + 1] & 0xff) << 8);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16301().get16(b, off));
    }
}
