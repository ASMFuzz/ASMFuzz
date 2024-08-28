import java.awt.Component;

public class MyJVMTest_1177 {

    static Thread thread = new Thread();

    static String throwableParam1 = "h<zJ$DRubw";

    static String throwableParam2Param1 = "\"aKa+1C'?q";

    static Throwable throwableParam2Param2 = new Throwable();

    static Throwable throwableParam2 = new Throwable(throwableParam2Param1, throwableParam2Param2);

    static boolean throwableParam3 = false;

    static boolean throwableParam4 = false;

    static Throwable throwable = new Throwable(throwableParam1, throwableParam2, throwableParam3, throwableParam4);

    Thread uncaughtException(Thread thread, Throwable throwable) {
        System.exit(1);
        return thread;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1177().uncaughtException(thread, throwable);
    }
}
