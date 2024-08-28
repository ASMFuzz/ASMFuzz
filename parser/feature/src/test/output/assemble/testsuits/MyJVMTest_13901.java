import java.io.*;

public class MyJVMTest_13901 {

    static int failed = 3;

    static boolean closed = true;

    void close() throws IOException {
        if (!closed) {
            closed = true;
            throw new IOException("close failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13901().close();
    }
}
