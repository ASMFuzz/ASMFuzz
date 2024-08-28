public class MyJVMTest_18205 {

    static char[] a = { '0', '=', Character.MAX_VALUE, Character.MIN_VALUE, 'g', 'b', Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE };

    static char[] b = { Character.MAX_VALUE, Character.MAX_VALUE, 'x', '?', Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] c = { 0, -32768, -19624, 0, 0, 0, 0, -32768, -32768, 32767 };

    static short[] d = { 32767, 32767, 32767, 32767, -6090, -32768, 32767, 32767, -32768, 32767 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_cp_unalndst(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18205().test_cp_unalndst(a, b, c, d);
    }
}
