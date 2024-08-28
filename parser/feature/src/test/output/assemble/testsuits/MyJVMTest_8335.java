public class MyJVMTest_8335 {

    static char[] a = { 'b', Character.MIN_VALUE, 'i', '0', Character.MIN_VALUE, Character.MIN_VALUE, ';', '0', Character.MIN_VALUE, '0' };

    static short[] b = { -657, 31605, 2175, 3534, 32767, -32768, 32767, 3791, 0, -32768 };

    char[] test_ci(char[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8335().test_ci(a, b);
    }
}
