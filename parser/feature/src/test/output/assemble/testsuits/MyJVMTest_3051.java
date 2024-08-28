import java.io.*;

public class MyJVMTest_3051 {

    static PipedOutputStream out = null;

    static PipedInputStream in = null;

    void run() {
        try {
            System.out.println("Writer started.");
            out.write(new byte[64 * 1024]);
        } catch (Throwable e) {
            System.out.println("Writer exception:");
            e.printStackTrace();
        } finally {
            System.out.println("Writer done.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3051().run();
    }
}
