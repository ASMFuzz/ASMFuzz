import java.util.concurrent.ThreadLocalRandom;

public class MyJVMTest_7694 {

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7694().pass();
    }
}
