public class MyJVMTest_15197 {

    static short[] a = { 0, -29020, 32767, 0, 0, -1816, 32767, 32767, 0, 32767 };

    static int[] b = { 1570261361, 1065362012, 0, 9, 0, 0, 0, 8, 1, 1335961349 };

    short[] test_ci_neg(short[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15197().test_ci_neg(a, b);
    }
}
