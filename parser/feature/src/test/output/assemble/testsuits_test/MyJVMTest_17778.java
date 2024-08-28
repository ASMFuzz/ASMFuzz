public class MyJVMTest_17778 {

    static char[] a = { Character.MIN_VALUE, 'n', Character.MIN_VALUE, '"', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', 'l', '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static short[] c = { -18994, 32767, 0, -32768, 1320, 32767, 32767, -22217, 20756, -32768 };

    static short[] d = { -17825, -32768, -32768, 14796, 0, 0, -32768, 32767, 32767, 0 };

    static int ALIGN_OFF = 8;

    char[] test_cp_alnsrc(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17778().test_cp_alnsrc(a, b, c, d);
    }
}
