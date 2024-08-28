public class MyJVMTest_8205 {

    static char[] a = { 'V', Character.MAX_VALUE, ']', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static char[] b = { 'V', '0', '0', 't', Character.MAX_VALUE, 'h', 'P', '0', 't', '0' };

    static short[] c = { 0, 32767, 5922, -10861, 0, 18089, -32768, 20590, 32767, -32768 };

    static short[] d = { 32767, 0, -19070, -254, -5060, 16806, -12301, -32768, 0, 0 };

    static int ALIGN_OFF = 8;

    char[] test_cp_alnsrc(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8205().test_cp_alnsrc(a, b, c, d);
    }
}
