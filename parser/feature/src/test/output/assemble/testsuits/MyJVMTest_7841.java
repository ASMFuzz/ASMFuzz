import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_7841 {

    static byte[] baisParam1 = { -18, -87, -69, 116, 3, 99, 83, -92, -89, 58 };

    static ByteArrayInputStream bais = new ByteArrayInputStream(baisParam1);

    ZipInputStream getInputStream(ByteArrayInputStream bais) throws IOException {
        return new JarInputStream(bais);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7841().getInputStream(bais));
    }
}
