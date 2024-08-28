import java.io.*;

public class MyJVMTest_12027 {

    static byte[] inParam1 = { 8, 36, 47, -44, 22, 83, 38, -67, 52, -10 };

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
        new MyJVMTest_12027().testRead(in);
    }
}
