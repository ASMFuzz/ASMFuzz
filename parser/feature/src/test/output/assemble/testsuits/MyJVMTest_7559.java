import java.io.*;

public class MyJVMTest_7559 {

    static PipedInputStream inPipe = null;

    static boolean stop = false;

    static boolean stopTest = false;

    void run() {
        while (!stop) {
            try {
                final int num = inPipe.available();
                if (num < 0) {
                    stopTest = true;
                }
            } catch (final IOException e) {
                System.err.println("Error on available:" + e.getMessage());
                e.printStackTrace(System.err);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7559().run();
    }
}
