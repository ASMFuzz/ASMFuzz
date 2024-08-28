import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_10890 {

    static int max = 0;

    static long timeout = 9142298285465702058L;

    static int count = 6;

    int waitfor(int max, long timeout) throws InterruptedException {
        final long start = System.currentTimeMillis();
        while (count < max && timeout > 0) {
            final long rest = timeout - (System.currentTimeMillis() - start);
            if (rest <= 0)
                break;
            wait(rest);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10890().waitfor(max, timeout));
    }
}
