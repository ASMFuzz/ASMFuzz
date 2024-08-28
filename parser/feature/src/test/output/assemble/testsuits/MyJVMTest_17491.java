import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_17491 {

    static int max = 0;

    static long timeout = 9223372036854775807L;

    static int count = 0;

    static Counter counter = null;

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
        System.out.println(new MyJVMTest_17491().waitfor(max, timeout));
    }
}
