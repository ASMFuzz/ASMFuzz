import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_7485 {

    static OutputStream out = new ByteArrayOutputStream();

    OutputStream derEncode(OutputStream out) throws IOException {
        throw new IOException();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7485().derEncode(out);
    }
}
