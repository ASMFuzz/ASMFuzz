import java.awt.Component;

public class MyJVMTest_10375 {

    static String threadParam1Param1Param1Param1Param1 = "%7Rmt Z@A#";

    static ThreadGroup threadParam1Param1Param1Param1 = new ThreadGroup(threadParam1Param1Param1Param1Param1);

    static String threadParam1Param1Param1Param2 = "XWhM`t3;;z";

    static ThreadGroup threadParam1Param1Param1 = new ThreadGroup(threadParam1Param1Param1Param1, threadParam1Param1Param1Param2);

    static String threadParam1Param1Param2 = "A@>4_QYL[-";

    static ThreadGroup threadParam1Param1 = new ThreadGroup(threadParam1Param1Param1, threadParam1Param1Param2);

    static String threadParam1Param2 = "M[!ex>-y2H";

    static ThreadGroup threadParam1 = new ThreadGroup(threadParam1Param1, threadParam1Param2);

    static Runnable threadParam2 = () -> {
    };

    static Thread thread = new Thread(threadParam1, threadParam2);

    static Throwable throwable = new Throwable();

    Thread uncaughtException(Thread thread, Throwable throwable) {
        System.exit(1);
        return thread;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10375().uncaughtException(thread, throwable);
    }
}
