public class MyJVMTest_11132 {

    static long[] a0 = { 9640887512155550L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L, 0, 5073857799965335192L, 9223372036854775807L, 0 };

    static long[] a1 = { 1611564167252203834L, -9223372036854775808L, 8148804180127767027L, 4773464993091947953L, 1614614883475032138L, 0, 4311979679478399096L, -9223372036854775808L, 0, 0 };

    long[] test_addi(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11132().test_addi(a0, a1);
    }
}
