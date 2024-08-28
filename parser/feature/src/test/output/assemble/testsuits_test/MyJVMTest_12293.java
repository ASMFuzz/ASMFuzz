public class MyJVMTest_12293 {

    static long[] a0 = { 8750508195762605878L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0, 9195260774320037365L, 0, -9223372036854775808L };

    long[] test_init(long[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12293().test_init(a0);
    }
}
