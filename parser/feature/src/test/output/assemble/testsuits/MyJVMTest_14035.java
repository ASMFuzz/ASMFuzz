public class MyJVMTest_14035 {

    static short[] a = { -32768, 0, 0, 0, 17976, 0, -32768, 0, 32767, -32768 };

    static int[] b = { 3, 1028838185, 3, 4, 4, 3, 0, 4, 7, 198399386 };

    static short c = 32767;

    static int d = 3;

    short[] test_vi(short[] a, int[] b, short c, int d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14035().test_vi(a, b, c, d);
    }
}
