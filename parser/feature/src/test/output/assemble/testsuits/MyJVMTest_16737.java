import java.util.logging.Logger;

public class MyJVMTest_16737 {

    static Throwable thrown = null;

    void run() {
        try {
            Logger.getLogger("foo").info("Done");
        } catch (Throwable x) {
            thrown = x;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16737().run();
    }
}
