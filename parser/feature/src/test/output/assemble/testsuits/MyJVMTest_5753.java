import java.io.*;

public class MyJVMTest_5753 {

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
        new MyJVMTest_5753().run();
    }
}
