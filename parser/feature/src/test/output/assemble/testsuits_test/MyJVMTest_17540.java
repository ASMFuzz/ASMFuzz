import java.awt.Color;

public class MyJVMTest_17540 {

    static boolean done = false;

    void finished() {
        synchronized (CycleDMImage.class) {
            done = true;
            CycleDMImage.class.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17540().finished();
    }
}
