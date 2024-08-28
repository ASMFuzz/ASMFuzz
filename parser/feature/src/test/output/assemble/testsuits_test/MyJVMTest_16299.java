public class MyJVMTest_16299 {

    static int[] a = { 1, -552884129, 7, -865132531, 2, 0, 8, -204569535, 1932606236, 9 };

    static float[] b = { 0.5733159f, Float.MAX_VALUE, 0.92279947f, 0f, 0.5091291f, Float.MAX_VALUE, 0.29377437f, Float.POSITIVE_INFINITY, 0.119001806f, 0.43478054f };

    static int c = 0;

    static float d = Float.MAX_VALUE;

    int[] test_vi_neg(int[] a, float[] b, int c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16299().test_vi_neg(a, b, c, d);
    }
}
