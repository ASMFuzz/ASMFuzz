import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_9971 {

    static byte[] baisParam1 = { 81, -41, -37, 83, -52, 8, -119, -96, -29, -120 };

    static ByteArrayInputStream bais = new ByteArrayInputStream(baisParam1);

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipInputStream getInputStream(ByteArrayInputStream bais) throws IOException {
        return new JarInputStream(bais);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9971().getInputStream(bais));
    }
}
