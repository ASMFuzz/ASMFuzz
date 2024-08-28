public class MyJVMTest_16990 {

    static char[] a = { Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static short[] b = { -25861, -28369, -3095, 32767, 32767, -32768, 32767, 32767, -13709, 0 };

    char[] test_ci_neg(char[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16990().test_ci_neg(a, b);
    }
}
