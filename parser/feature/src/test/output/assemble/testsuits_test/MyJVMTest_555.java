import java.util.concurrent.CountDownLatch;

public class MyJVMTest_555 {

    static long coeffA = 911797540100588398L;

    static long coeffB = 1781209158534991822L;

    static long coeffC = 9223372036854775807L;

    static long number = -9223372036854775808L;

    static long busyTime = 9223372036854775807L;

    static CountDownLatch startLatch = null;

    static CountDownLatch joinLatch = null;

    long quadratic(long coeffA, long coeffB, long coeffC, long number) {
        return (coeffA * (number * number) + coeffB * number + coeffC);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_555().quadratic(coeffA, coeffB, coeffC, number));
    }
}
