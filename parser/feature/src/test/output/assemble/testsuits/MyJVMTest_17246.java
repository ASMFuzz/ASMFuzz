import java.util.concurrent.ThreadLocalRandom;

public class MyJVMTest_17246 {

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17246().pass();
    }
}
