import java.io.*;

public class MyJVMTest_17885 {

    static PipedInputStream snk = null;

    void run() {
        try {
            snk.read();
        } catch (Exception e) {
            System.err.println("Test failed: unexpected exception");
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17885().run();
    }
}
