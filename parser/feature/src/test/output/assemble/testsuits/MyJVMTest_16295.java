public class MyJVMTest_16295 {

    static char[] a = { '0', 'U', '4', '0', Character.MIN_VALUE, Character.MAX_VALUE, 'K', Character.MIN_VALUE, '0', 'h' };

    static char[] b = { Character.MIN_VALUE, '-', Character.MAX_VALUE, Character.MAX_VALUE, 'T', Character.MIN_VALUE, 'T', 'b', Character.MAX_VALUE, '0' };

    static short[] c = { -24425, 0, 32767, 0, -32768, -32768, -32768, -32768, 32767, -32768 };

    static short[] d = { 32767, 11794, 32767, -32768, 32767, 0, -9605, -31170, -386, 0 };

    char[] test_cp_neg(char[] a, char[] b, short[] c, short[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16295().test_cp_neg(a, b, c, d);
    }
}
