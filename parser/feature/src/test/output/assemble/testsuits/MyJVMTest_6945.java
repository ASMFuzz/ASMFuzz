public class MyJVMTest_6945 {

    static int[] a = { 5, 0, 1936705145, 8, 8, -686165566, 7, 388078334, -1957227013, 784795514 };

    static float[] b = { 0.16432887f, 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.10307866f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

    static int c = 601418333;

    static float d = Float.MAX_VALUE;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_vi_unaln(int[] a, float[] b, int c, float d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6945().test_vi_unaln(a, b, c, d);
    }
}
