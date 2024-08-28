import java.lang.Thread.UncaughtExceptionHandler;

public class MyJVMTest_15585 {

    void run() {
        throw new RuntimeException("This is an exception.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15585().run();
    }
}
