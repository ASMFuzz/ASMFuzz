public class MyJVMTest_7454 {

    static char[] a = { Character.MAX_VALUE, Character.MIN_VALUE, '8', '0', Character.MAX_VALUE, Character.MIN_VALUE, '$', '0', Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] b = { 0, 30520, -17558, 0, -24237, 32767, 30172, -32768, 32767, 32767 };

    char[] test_ci_neg(char[] a, short[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7454().test_ci_neg(a, b);
    }
}
