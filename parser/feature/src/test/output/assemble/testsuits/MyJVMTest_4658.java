import java.io.*;

public class MyJVMTest_4658 {

    static int len = 3;

    static int chunk = 9;

    void close() throws IOException {
        if (len == 0)
            throw new IOException("Already closed");
        len = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4658().close();
    }
}
