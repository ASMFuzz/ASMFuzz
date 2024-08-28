public class MyJVMTest_1657 {

    static short[] a = { -30700, -32768, 13821, 32767, 0, 32767, 32767, 0, 32767, -11592 };

    static short[] b = { -32768, -32768, -2753, 32767, -32768, 0, 0, 32767, 32767, 0 };

    short[] test_2ci_neg(short[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1657().test_2ci_neg(a, b);
    }
}
