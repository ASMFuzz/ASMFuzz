import java.awt.Color;

public class MyJVMTest_7976 {

    static boolean done = false;

    void finished() {
        synchronized (CycleDMImage.class) {
            done = true;
            CycleDMImage.class.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7976().finished();
    }
}
