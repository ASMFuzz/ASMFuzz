import java.io.*;

public class MyJVMTest_14049 {

    static int len = -336626256;

    static int chunk = 1430152994;

    void close() throws IOException {
        if (len == 0)
            throw new IOException("Already closed");
        len = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14049().close();
    }
}
