import java.io.*;

public class MyJVMTest_15196 {

    void run() {
        File file = new File("xxyyzz");
        try {
            for (; ; ) {
                file.deleteOnExit();
            }
        } catch (IllegalStateException ise) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15196().run();
    }
}
