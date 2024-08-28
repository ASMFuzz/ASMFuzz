public class MyJVMTest_4726 {

    static long[] a = { 0, 0, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, -2289443742890304265L };

    static long b = 9223372036854775807L;

    long[] test_vi(long[] a, long b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4726().test_vi(a, b);
    }
}
