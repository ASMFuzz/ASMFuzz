import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_10951 {

    static byte[] inParam1 = { 42, 102, -114, -38, 80, -15, -110, 70, 57, -88 };

    static int inParam2 = 784;

    static int inParam3 = 209;

    static InputStream in = new ByteArrayInputStream(inParam1, inParam2, inParam3);

    InputStream testRead(InputStream in) throws Exception {
        in.close();
        try {
            in.read();
            throw new Exception("read allowed after stream is closed");
        } catch (IOException e) {
        }
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10951().testRead(in);
    }
}
