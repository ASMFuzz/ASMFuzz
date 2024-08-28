import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class MyJVMTest_8229 {

    static long startTime = -9223372036854775808L;

    long secondsElapsedSince(long startTime) {
        return NANOSECONDS.toSeconds(System.nanoTime() - startTime);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8229().secondsElapsedSince(startTime));
    }
}
