public class MyJVMTest_16405 {

    static short[] a = { 0, -27296, 0, -17074, 20226, -32768, -32768, 0, 0, 32767 };

    static int[] b = { 6, 6, 4, 0, 0, 0, 1, 0, 9, 1 };

    short[] test_ci_oppos(short[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16405().test_ci_oppos(a, b);
    }
}
