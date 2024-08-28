public class MyJVMTest_6895 {

    static short[] a = { 2013, 31843, 32767, 32767, 0, 32767, 19579, -32768, 25895, -18368 };

    static int[] b = { 5, 0, 2, 2095198046, 9, 0, 7, 8, 0, 0 };

    short[] test_ci_oppos(short[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6895().test_ci_oppos(a, b);
    }
}
