import java.io.*;

public class MyJVMTest_9922 {

    static int OPEN = 1;

    static int CLOSED = 2;

    static int status = OPEN;

    void close() throws IOException {
        if (status == OPEN) {
            status = CLOSED;
        } else
            throw new IOException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9922().close();
    }
}
