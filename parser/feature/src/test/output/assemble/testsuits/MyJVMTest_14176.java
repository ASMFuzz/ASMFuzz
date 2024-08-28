import java.io.*;

public class MyJVMTest_14176 {

    void close() throws IOException {
        throw new IOException("Bad close operation");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14176().close();
    }
}
