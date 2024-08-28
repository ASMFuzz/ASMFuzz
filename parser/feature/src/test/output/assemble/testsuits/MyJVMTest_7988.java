public class MyJVMTest_7988 {

    static char[] a = { '0', '0', Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, '*', '0', Character.MAX_VALUE };

    static char[] b = { Character.MAX_VALUE, Character.MIN_VALUE, '<', Character.MIN_VALUE, 'q', Character.MIN_VALUE, '$', '0', 'O', Character.MAX_VALUE };

    static short[] c = { -32768, 32767, -32768, 0, -32768, -7991, -32768, 32767, 32767, 0 };

    static short[] d = { -32768, 32767, -32768, -32768, 0, -32768, -11789, -23149, -12597, 0 };

    static int ALIGN_OFF = 8;

    char[] test_cp_alndst(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7988().test_cp_alndst(a, b, c, d);
    }
}
