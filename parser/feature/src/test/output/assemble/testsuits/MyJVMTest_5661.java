public class MyJVMTest_5661 {

    static short[] a = { 32767, -13337, 32767, 0, 0, 32767, -32768, -6531, -32768, 0 };

    static int[] b = { 0, 0, 7, 0, 5, 0, 4, 3, 4, 0 };

    short[] test_ci(short[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5661().test_ci(a, b);
    }
}
