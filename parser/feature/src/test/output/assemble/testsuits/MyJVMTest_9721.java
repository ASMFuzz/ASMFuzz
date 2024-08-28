import java.util.concurrent.CountDownLatch;

public class MyJVMTest_9721 {

    static long coeffA = -9223372036854775808L;

    static long coeffB = 9223372036854775807L;

    static long coeffC = 9223372036854775807L;

    static long number = 955729896305881932L;

    static long busyTime = -9223372036854775808L;

    static CountDownLatch startLatch = null;

    static CountDownLatch joinLatch = null;

    long quadratic(long coeffA, long coeffB, long coeffC, long number) {
        return (coeffA * (number * number) + coeffB * number + coeffC);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9721().quadratic(coeffA, coeffB, coeffC, number));
    }
}
