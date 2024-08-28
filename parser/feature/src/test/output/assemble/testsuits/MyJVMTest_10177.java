import java.util.*;

public class MyJVMTest_10177 {

    static int TEST_SIZE = 5000;

    static Integer[] KEYS = new Integer[TEST_SIZE];

    static Long[] VALUES = new Long[TEST_SIZE];

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10177().pass();
    }
}
