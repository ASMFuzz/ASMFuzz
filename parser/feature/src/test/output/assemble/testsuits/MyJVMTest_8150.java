import java.lang.management.*;

public class MyJVMTest_8150 {

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
        new MyJVMTest_8150().goSleep(ms);
    }
}
