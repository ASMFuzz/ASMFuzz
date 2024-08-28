public class MyJVMTest_15097 {

    static short[] a = { -32768, 30083, 32767, 32767, 0, -32768, -32768, 14394, 19926, 27307 };

    static int[] b = { 1, 0, 5, 5, 0, 996149741, 0, 0, 0, 0 };

    short[] test_ci(short[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15097().test_ci(a, b);
    }
}
