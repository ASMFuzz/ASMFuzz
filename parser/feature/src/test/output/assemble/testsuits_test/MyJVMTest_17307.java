import javax.swing.JFrame;

public class MyJVMTest_17307 {

    static String threadParam1 = "H!tsZTbXAW";

    static Thread thread = new Thread(threadParam1);

    static Throwable exception = new Throwable();

    Throwable uncaughtException(Thread thread, Throwable exception) {
        exception.printStackTrace();
        System.exit(1);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17307().uncaughtException(thread, exception);
    }
}
