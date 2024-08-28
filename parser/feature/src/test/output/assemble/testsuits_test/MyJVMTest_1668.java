import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_1668 {

    static int max = 9;

    static long timeout = 9223372036854775807L;

    static int count = 2;

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
        System.out.println(new MyJVMTest_1668().waitfor(max, timeout));
    }
}
