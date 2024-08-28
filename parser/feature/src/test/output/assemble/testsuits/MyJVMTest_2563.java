public class MyJVMTest_2563 {

    static long[] a = { -9223372036854775808L, 0, -8933263637829245068L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L };

    static long[] b = { 0, -9223372036854775808L, -9223372036854775808L, -4870171088604916779L, -4739456801501497480L, 9223372036854775807L, -821687994465579794L, -9223372036854775808L, 7969772183252963322L, -9223372036854775808L };

    static int OFFSET = 3;

    long[] test_cp_off(long[] a, long[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2563().test_cp_off(a, b);
    }
}
