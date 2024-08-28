import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_15466 {

    static byte[] inParam1 = { 92, -59, -12, 46, -128, 109, 66, 52, 71, 26 };

    static int inParam2 = 972;

    static int inParam3 = 229;

    static InputStream in = new ByteArrayInputStream(inParam1, inParam2, inParam3);

    static OutputStream out = new ByteArrayOutputStream();

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
        new MyJVMTest_15466().copyStream(in, out);
    }
}
