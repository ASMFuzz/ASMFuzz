import java.lang.management.*;

public class MyJVMTest_17284 {

    static String curThreadParam1Param1 = "CvZW['bpBh";

    static ThreadGroup curThreadParam1 = new ThreadGroup(curThreadParam1Param1);

    static String curThreadParam2 = "{=]YW6E&lV";

    static Thread curThread = new Thread(curThreadParam1, curThreadParam2);

    static long prev_size = -8566833959848762903L;

    static long curr_size = 2590667023868856138L;

    long checkResult(Thread curThread, long prev_size, long curr_size) {
        if (curr_size < prev_size) {
            throw new RuntimeException("Allocated bytes " + curr_size + " expected >= " + prev_size);
        }
        System.out.println(curThread.getName() + " Previous allocated bytes = " + prev_size + " Current allocated bytes = " + curr_size);
        return prev_size;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17284().checkResult(curThread, prev_size, curr_size);
    }
}
