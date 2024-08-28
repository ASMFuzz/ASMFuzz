import java.io.*;

public class MyJVMTest_15862 {

    static boolean closed = false;

    void close() throws IOException {
        if (!closed) {
            closed = true;
            throw new IOException("close failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15862().close();
    }
}
