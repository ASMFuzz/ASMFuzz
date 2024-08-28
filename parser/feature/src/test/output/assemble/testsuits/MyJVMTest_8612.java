public class MyJVMTest_8612 {

    static char[] a = { '0', Character.MIN_VALUE, '<', Character.MAX_VALUE, Character.MAX_VALUE, '=', Character.MAX_VALUE, 'k', Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, 'j', 'S', Character.MAX_VALUE, Character.MIN_VALUE, '&', '0', Character.MAX_VALUE, Character.MIN_VALUE, 'X' };

    static short[] c = { 6381, 32767, -32768, -18824, -32768, -32768, -32768, 32767, 0, 32767 };

    static short[] d = { 32767, 0, -32768, -32768, -32768, 32767, -32768, 31746, 32767, -18873 };

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
        new MyJVMTest_8612().test_cp_unalndst(a, b, c, d);
    }
}
