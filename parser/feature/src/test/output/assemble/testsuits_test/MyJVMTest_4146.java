public class MyJVMTest_4146 {

    static long val = 0;

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
        new MyJVMTest_4146().testRorLongZero(val);
    }
}
