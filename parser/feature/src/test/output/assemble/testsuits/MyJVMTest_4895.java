public class MyJVMTest_4895 {

    static short[] a = { -768, 7131, 0, -32768, 0, 0, 0, -19324, 0, 4437 };

    static short[] b = { 32767, -32594, -32768, -32612, -6979, -3380, 8499, 0, -32768, -7894 };

    static int OFFSET = 3;

    short[] test_2ci_off(short[] a, short[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4895().test_2ci_off(a, b);
    }
}
