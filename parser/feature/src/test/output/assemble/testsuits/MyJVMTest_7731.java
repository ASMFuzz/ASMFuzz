import java.lang.management.*;

public class MyJVMTest_7731 {

    static String curThreadParam1Param1 = ";k2SYV8Yqe";

    static ThreadGroup curThreadParam1 = new ThreadGroup(curThreadParam1Param1);

    static String curThreadParam2 = "h_cx+uH?o:";

    static Thread curThread = new Thread(curThreadParam1, curThreadParam2);

    static long prev_size = 0;

    static long curr_size = 541244878198441900L;

    long checkResult(Thread curThread, long prev_size, long curr_size) {
        if (curr_size < prev_size) {
            throw new RuntimeException("Allocated bytes " + curr_size + " expected >= " + prev_size);
        }
        System.out.println(curThread.getName() + " Previous allocated bytes = " + prev_size + " Current allocated bytes = " + curr_size);
        return prev_size;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7731().checkResult(curThread, prev_size, curr_size);
    }
}
