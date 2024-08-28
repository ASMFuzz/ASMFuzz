import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_792 {

    static byte[] baisParam1 = { -71, 29, 95, -65, -18, -94, 30, -127, -100, -128 };

    static int baisParam2 = 53;

    static int baisParam3 = 537;

    static ByteArrayInputStream bais = new ByteArrayInputStream(baisParam1, baisParam2, baisParam3);

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipInputStream getInputStream(ByteArrayInputStream bais) throws IOException {
        return new JarInputStream(bais);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_792().getInputStream(bais));
    }
}
