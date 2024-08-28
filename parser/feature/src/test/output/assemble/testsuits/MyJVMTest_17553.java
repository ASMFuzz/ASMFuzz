public class MyJVMTest_17553 {

    static char[] a = { '0', Character.MIN_VALUE, Character.MIN_VALUE, 'z', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] b = { Character.MAX_VALUE, 'W', Character.MIN_VALUE, Character.MAX_VALUE, 'N', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] c = { -18625, -32768, 0, -32768, 13611, -32768, 32767, 0, 0, -20155 };

    static short[] d = { 0, 8520, 0, 0, 0, -10766, -32768, -32768, 28526, 32767 };

    static int ALIGN_OFF = 8;

    char[] test_cp_alndst(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17553().test_cp_alndst(a, b, c, d);
    }
}
