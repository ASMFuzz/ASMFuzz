import javax.swing.JFrame;

public class MyJVMTest_7753 {

    static String threadParam1Param1Param1Param1Param1 = "M'S6`{!s|u";

    static ThreadGroup threadParam1Param1Param1Param1 = new ThreadGroup(threadParam1Param1Param1Param1Param1);

    static String threadParam1Param1Param1Param2 = "UJkuL+KP5S";

    static ThreadGroup threadParam1Param1Param1 = new ThreadGroup(threadParam1Param1Param1Param1, threadParam1Param1Param1Param2);

    static String threadParam1Param1Param2 = "W!j[qQ=&t9";

    static ThreadGroup threadParam1Param1 = new ThreadGroup(threadParam1Param1Param1, threadParam1Param1Param2);

    static String threadParam1Param2 = ">pyq@Qr.8r";

    static ThreadGroup threadParam1 = new ThreadGroup(threadParam1Param1, threadParam1Param2);

    static Runnable threadParam2 = () -> {
    };

    static Thread thread = new Thread(threadParam1, threadParam2);

    static String exceptionParam1 = "o#\"+E}*.WF";

    static String exceptionParam2Param1 = "aMY`RnF 61";

    static String exceptionParam2Param2Param1 = "oBlopQT/4t";

    static Throwable exceptionParam2Param2Param2 = new Throwable();

    static Throwable exceptionParam2Param2 = new Throwable(exceptionParam2Param2Param1, exceptionParam2Param2Param2);

    static Throwable exceptionParam2 = new Throwable(exceptionParam2Param1, exceptionParam2Param2);

    static boolean exceptionParam3 = false;

    static boolean exceptionParam4 = false;

    static Throwable exception = new Throwable(exceptionParam1, exceptionParam2, exceptionParam3, exceptionParam4);

    Throwable uncaughtException(Thread thread, Throwable exception) {
        exception.printStackTrace();
        System.exit(1);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7753().uncaughtException(thread, exception);
    }
}
