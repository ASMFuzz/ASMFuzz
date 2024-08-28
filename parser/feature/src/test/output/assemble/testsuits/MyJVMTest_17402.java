import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_17402 {

    static boolean messageReceived = false;

    void doWait() {
        while (!messageReceived) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Got unexpected exception: " + e);
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17402().doWait();
    }
}
