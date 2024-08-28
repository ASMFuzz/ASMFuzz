import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_5448 {

    static byte[] baisParam1 = { 113, -90, -114, 48, 48, -113, 7, 25, -67, -121 };

    static int baisParam2 = 305;

    static int baisParam3 = 525;

    static ByteArrayInputStream bais = new ByteArrayInputStream(baisParam1, baisParam2, baisParam3);

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipInputStream getInputStream(ByteArrayInputStream bais) throws IOException {
        return new ZipInputStream(bais);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5448().getInputStream(bais));
    }
}
