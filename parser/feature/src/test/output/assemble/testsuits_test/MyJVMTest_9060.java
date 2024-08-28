public class MyJVMTest_9060 {

    static String threadParam1Param1Param1Param1Param1 = "s]JK!<l,K*";

    static ThreadGroup threadParam1Param1Param1Param1 = new ThreadGroup(threadParam1Param1Param1Param1Param1);

    static String threadParam1Param1Param1Param2 = "!1J=}XskGQ";

    static ThreadGroup threadParam1Param1Param1 = new ThreadGroup(threadParam1Param1Param1Param1, threadParam1Param1Param1Param2);

    static String threadParam1Param1Param2 = "DLsO]_b'UQ";

    static ThreadGroup threadParam1Param1 = new ThreadGroup(threadParam1Param1Param1, threadParam1Param1Param2);

    static String threadParam1Param2 = "W`)|JK?FoJ";

    static ThreadGroup threadParam1 = new ThreadGroup(threadParam1Param1, threadParam1Param2);

    static Runnable threadParam2 = () -> {
    };

    static String threadParam3 = "dSz*.5UY?j";

    static long threadParam4 = 9223372036854775807L;

    static Thread thread = new Thread(threadParam1, threadParam2, threadParam3, threadParam4);

    static String throwableParam1Param1 = "e?EUp]ga_(";

    static Throwable throwableParam1Param2 = new Throwable();

    static Throwable throwableParam1 = new Throwable(throwableParam1Param1, throwableParam1Param2);

    static Throwable throwable = new Throwable(throwableParam1);

    Throwable uncaughtException(Thread thread, Throwable throwable) {
        throwable.printStackTrace();
        System.exit(1);
        return throwable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9060().uncaughtException(thread, throwable);
    }
}
