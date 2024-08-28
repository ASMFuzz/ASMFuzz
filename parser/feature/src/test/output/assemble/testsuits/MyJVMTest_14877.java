import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_14877 {

    static byte[] baisParam1 = { 9, -63, 86, -10, 107, -105, -119, -69, -72, 117 };

    static int baisParam2 = 388;

    static int baisParam3 = 532;

    static ByteArrayInputStream bais = new ByteArrayInputStream(baisParam1, baisParam2, baisParam3);

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipInputStream getInputStream(ByteArrayInputStream bais) throws IOException {
        return new ZipInputStream(bais);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14877().getInputStream(bais));
    }
}
