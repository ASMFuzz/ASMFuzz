import java.io.*;

public class MyJVMTest_4778 {

    void close() throws IOException {
        throw new IOException("Bad close operation");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4778().close();
    }
}
