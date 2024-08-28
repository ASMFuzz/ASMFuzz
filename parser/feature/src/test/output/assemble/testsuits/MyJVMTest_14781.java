public class MyJVMTest_14781 {

    static long[] a = { 0, -2058321779131168468L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, -4651527860933555947L, -348814082077965606L, 0 };

    long[] test_ci(long[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14781().test_ci(a);
    }
}
