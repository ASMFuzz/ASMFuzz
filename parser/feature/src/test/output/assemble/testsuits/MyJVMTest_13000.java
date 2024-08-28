import java.util.concurrent.ThreadLocalRandom;

public class MyJVMTest_13000 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13000().check(cond);
    }
}
