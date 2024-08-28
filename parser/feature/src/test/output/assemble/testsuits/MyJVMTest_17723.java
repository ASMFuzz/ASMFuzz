import java.lang.management.*;

public class MyJVMTest_17723 {

    static long ms = 0;

    long goSleep(long ms) throws Exception {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Unexpected exception is thrown.");
            throw e;
        }
        return ms;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17723().goSleep(ms);
    }
}
