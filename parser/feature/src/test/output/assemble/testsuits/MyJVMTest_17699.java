public class MyJVMTest_17699 {

    static int[] a = { -1044410881, 995252347, 0, 1691138836, 0, 1, 9, 2, 0, 3 };

    static int[] b = { 8, 0, 8, 0, 2, 0, 0, 3, 0, 1079889550 };

    static float[] c = { Float.POSITIVE_INFINITY, 0.7785124f, 0.46723986f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0f };

    static float[] d = { Float.MAX_VALUE, Float.MIN_VALUE, 0.8338678f, 0.5955065f, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, 0.34254992f };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17699().test_cp_alnsrc(a, b, c, d);
    }
}
