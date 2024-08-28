public class MyJVMTest_4644 {

    static short[] a = { 32767, -32768, -32768, -32768, 0, -32768, 32767, 0, 32767, -32768 };

    static int[] b = { 1533957096, 5, 0, 0, -786280783, -756754952, 7, 0, -1979026435, 0 };

    static short c = 32767;

    static int d = 7;

    short[] test_vi(short[] a, int[] b, short c, int d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4644().test_vi(a, b, c, d);
    }
}
