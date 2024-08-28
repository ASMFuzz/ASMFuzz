public class MyJVMTest_4853 {

    static long val = 9223372036854775807L;

    long testRolLongZero(long val) {
        int count = 42;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                count = 0;
            }
        }
        long res = Long.rotateLeft(val, count);
        if (res != val) {
            throw new RuntimeException("test_rol_long_zero failed: " + res + " != " + val);
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4853().testRolLongZero(val);
    }
}
