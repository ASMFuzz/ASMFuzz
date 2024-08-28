public class MyJVMTest_6793 {

    static char[] a = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'g', '0', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'b', '(', 'H', 's', '0', '0', Character.MAX_VALUE };

    static short[] c = { 0, 25608, -32768, 0, 0, 0, -32768, -12747, -32768, 32767 };

    static short[] d = { 0, 32767, 32767, 32767, -32768, -2011, 32767, -32768, 32767, 4350 };

    char[] test_cp_neg(char[] a, char[] b, short[] c, short[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6793().test_cp_neg(a, b, c, d);
    }
}
