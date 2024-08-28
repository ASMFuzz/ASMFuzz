public class MyJVMTest_17112 {

    static long[] a0 = { 5425766708964427142L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 1607942044015125261L };

    long[] test_unrl_init(long[] a0) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = 0;
            a0[i + 1] = 1;
            a0[i + 2] = 2;
            a0[i + 3] = 3;
        }
        for (; i < a0.length; i++) {
            a0[i] = (long) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17112().test_unrl_init(a0);
    }
}
