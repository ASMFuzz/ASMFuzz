import java.util.concurrent.CountDownLatch;

public class MyJVMTest_2838 {

    static int receivedErrorParam1 = 92;

    static CountDownLatch receivedError = new CountDownLatch(receivedErrorParam1);

    static String expectedParam1 = "G?0oC#V+9%";

    static String expectedParam2Param1 = "xzJXA\\N1$n";

    static String expectedParam2Param2Param1 = "$S44j6/^fg";

    static String expectedParam2Param2Param2Param1Param1 = " :WOrZ4cZT";

    static String expectedParam2Param2Param2Param1Param2Param1 = "\"j#Np\\fwxh";

    static Throwable expectedParam2Param2Param2Param1Param2 = new Throwable(expectedParam2Param2Param2Param1Param2Param1);

    static Throwable expectedParam2Param2Param2Param1 = new Throwable(expectedParam2Param2Param2Param1Param1, expectedParam2Param2Param2Param1Param2);

    static Throwable expectedParam2Param2Param2 = new Throwable(expectedParam2Param2Param2Param1);

    static Throwable expectedParam2Param2 = new Throwable(expectedParam2Param2Param1, expectedParam2Param2Param2);

    static boolean expectedParam2Param3 = false;

    static boolean expectedParam2Param4 = true;

    static Throwable expectedParam2 = new Throwable(expectedParam2Param1, expectedParam2Param2, expectedParam2Param3, expectedParam2Param4);

    static Throwable expected = new Throwable(expectedParam1, expectedParam2);

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
        new MyJVMTest_2838().installUncaughtException(receivedError, expected);
    }
}
