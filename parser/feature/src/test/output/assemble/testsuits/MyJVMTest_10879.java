public class MyJVMTest_10879 {

    static short[] a = { 0, -32768, -32768, 0, 32767, 0, 4183, 0, 0, -26905 };

    static short[] b = { 32767, 32767, -32768, 4618, -14052, -29408, 19620, 0, 32767, 32767 };

    short[] test_2ci_neg(short[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10879().test_2ci_neg(a, b);
    }
}
