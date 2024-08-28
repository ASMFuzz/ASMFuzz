public class MyJVMTest_13507 {

    static long val = -7160239345780229686L;

    long testRorLongZero(long val) {
        int count = 42;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                count = 0;
            }
        }
        long res = Long.rotateRight(val, count);
        if (res != val) {
            throw new RuntimeException("test_ror_long_zero failed: " + res + " != " + val);
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13507().testRorLongZero(val);
    }
}
