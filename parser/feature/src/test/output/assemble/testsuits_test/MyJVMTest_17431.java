public class MyJVMTest_17431 {

    static char[] a = { Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', 'u', 'l', Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE };

    static short[] c = { -18164, 32767, 3671, -8905, -32768, -32768, 0, 0, 32767, -32768 };

    static short[] d = { -32768, -11435, 0, 0, 0, 0, 32767, 32767, 0, -31986 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_cp_unalnsrc(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17431().test_cp_unalnsrc(a, b, c, d);
    }
}
