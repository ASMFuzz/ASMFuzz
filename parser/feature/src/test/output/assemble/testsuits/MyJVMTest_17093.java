import java.lang.management.*;

public class MyJVMTest_17093 {

    static Runnable tParam1 = () -> {
    };

    static String tParam2 = "WN)!wPFy+A";

    static Thread t = new Thread(tParam1, tParam2);

    static Thread.State state = null;

    Thread.State waitForThreadState(Thread t, Thread.State state) throws InterruptedException {
        while (t.getState() != state) {
            Thread.sleep(3);
        }
        return state;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17093().waitForThreadState(t, state);
    }
}
