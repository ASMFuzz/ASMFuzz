public class MyJVMTest_7569 {

    static long[] a0 = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 4903186725249379025L, 0, 0, 9223372036854775807L, -1027169605720862794L };

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
        new MyJVMTest_7569().test_unrl_init(a0);
    }
}
