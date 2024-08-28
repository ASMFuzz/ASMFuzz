import java.util.*;

public class MyJVMTest_454 {

    static Object go = new Object();

    void finishDump() {
        synchronized (go) {
            try {
                go.notifyAll();
            } catch (Exception e) {
                throw new RuntimeException("Unexpected exception" + e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_454().finishDump();
    }
}
