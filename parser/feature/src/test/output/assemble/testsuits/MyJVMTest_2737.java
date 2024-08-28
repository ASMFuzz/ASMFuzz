import java.io.*;

public class MyJVMTest_2737 {

    static byte[] inParam1 = { -82, 77, 42, -28, 71, 114, -117, 23, -93, 13 };

    static InputStream in = new ByteArrayInputStream(inParam1);

    InputStream testRead(InputStream in) throws Exception {
        in.close();
        byte[] buf = new byte[2];
        try {
            in.read(buf, 0, 1);
            throw new Exception("Should not allow read on a closed stream");
        } catch (IOException e) {
        }
        try {
            in.read(buf, 0, 0);
            throw new Exception("Should not allow read on a closed stream");
        } catch (IOException e) {
        }
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2737().testRead(in);
    }
}
