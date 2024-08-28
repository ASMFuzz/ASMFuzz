import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_6011 {

    static byte[] inParam1 = { 50, 40, 36, 44, 47, 116, -53, 110, 113, -21 };

    static InputStream in = new ByteArrayInputStream(inParam1);

    static int outParam1 = 509;

    static OutputStream out = new ByteArrayOutputStream(outParam1);

    static int BUFFER_LENGTH = 1024;

    OutputStream copyStream(InputStream in, OutputStream out) throws IOException {
        int n;
        byte[] buffer = new byte[BUFFER_LENGTH];
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        out.flush();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6011().copyStream(in, out);
    }
}
