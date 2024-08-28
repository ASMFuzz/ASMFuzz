import java.io.*;

public class MyJVMTest_5701 {

    static PipedWriter w = null;

    static PipedReader r = null;

    void run() {
        try {
            System.out.println("Reader reading...");
            r.read(new char[2048], 0, 2048);
            System.out.println("Reader closing stream...");
            r.close();
            Thread.sleep(3000);
        } catch (Throwable e) {
            System.out.println("Reader exception:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5701().run();
    }
}
