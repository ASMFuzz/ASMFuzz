public class MyJVMTest_912 {

    static short[] a = { 0, 0, 32767, 32767, 0, -32768, 32767, 0, 0, 32767 };

    static short[] b = { 0, 0, -32768, -32768, -32768, -13112, 4065, 32767, 0, 32767 };

    static int[] c = { 7, 0, 0, 4, 0, 0, 2, -1796606388, 5, 3 };

    static int[] d = { -769698535, 0, 777782912, -839250549, 0, 0, -1141170577, 5, 0, 3 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_912().test_cp_alnsrc(a, b, c, d);
    }
}
