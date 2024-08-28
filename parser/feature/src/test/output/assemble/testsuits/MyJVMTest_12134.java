import java.util.concurrent.CountDownLatch;

public class MyJVMTest_12134 {

    static int receivedErrorParam1 = 265;

    static CountDownLatch receivedError = new CountDownLatch(receivedErrorParam1);

    static String expectedParam1Param1 = "*zS=V0E}V2";

    static Throwable expectedParam1 = new Throwable(expectedParam1Param1);

    static Throwable expected = new Throwable(expectedParam1);

    Throwable installUncaughtException(CountDownLatch receivedError, Throwable expected) {
        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            if (throwable == expected) {
                System.out.println("Received uncaught exception " + expected.getClass());
                receivedError.countDown();
            }
        });
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12134().installUncaughtException(receivedError, expected);
    }
}
