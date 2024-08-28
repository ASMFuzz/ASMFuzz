import java.io.*;

public class MyJVMTest_3764 {

    static PipedOutputStream outPipe = null;

    static Thread sink = null;

    static boolean stop = false;

    void cleanup() throws Exception {
        if (sink != null) {
            stop = true;
            sink.interrupt();
            try {
                sink.join();
            } catch (InterruptedException e) {
            }
            stop = false;
            outPipe.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3764().cleanup();
    }
}
