import java.io.*;

public class MyJVMTest_6381 {

    static boolean closed = false;

    void close() throws IOException {
        if (!closed) {
            closed = true;
            throw new IOException("close failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6381().close();
    }
}
