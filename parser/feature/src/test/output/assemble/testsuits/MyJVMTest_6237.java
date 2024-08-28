import java.util.*;

public class MyJVMTest_6237 {

    static Object go = new Object();

    void waitForDump() {
        synchronized (go) {
            try {
                go.wait();
            } catch (Exception e) {
                throw new RuntimeException("Unexpected exception" + e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6237().waitForDump();
    }
}
