import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_17401 {

    static byte[] baisParam1 = { 98, 10, -23, 12, -21, -33, 44, -55, -75, -9 };

    static ByteArrayInputStream bais = new ByteArrayInputStream(baisParam1);

    ZipInputStream getInputStream(ByteArrayInputStream bais) throws IOException {
        return new JarInputStream(bais);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17401().getInputStream(bais));
    }
}
