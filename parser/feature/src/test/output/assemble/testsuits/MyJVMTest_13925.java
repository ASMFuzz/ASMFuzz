import java.util.logging.LogManager;

public class MyJVMTest_13925 {

    void randomDelay() {
        int runs = (int) Math.random() * 1000000;
        int c = 0;
        for (int i = 0; i < runs; ++i) {
            c = c + i;
        }
    }

    void run() {
        randomDelay();
        LogManager.getLogManager();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13925().run();
    }
}
