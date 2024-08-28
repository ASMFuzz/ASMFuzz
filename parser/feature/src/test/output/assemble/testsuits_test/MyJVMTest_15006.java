public class MyJVMTest_15006 {

    static short[] a = { 0, 23086, -32768, 32767, 0, 32767, 2696, 32767, -32768, 27828 };

    static short b = -32768;

    short[] test_vi_neg(short[] a, short b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15006().test_vi_neg(a, b);
    }
}
