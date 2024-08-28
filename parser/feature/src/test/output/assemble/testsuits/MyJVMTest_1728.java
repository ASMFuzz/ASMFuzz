import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_1728 {

    static byte[] inParam1 = { -71, -5, -50, -60, -116, -54, -66, 78, 2, 105 };

    static int inParam2 = 889;

    static int inParam3 = 314;

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
        new MyJVMTest_1728().testRead(in);
    }
}
