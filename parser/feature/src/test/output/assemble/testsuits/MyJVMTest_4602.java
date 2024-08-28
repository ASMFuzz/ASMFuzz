public class MyJVMTest_4602 {

    static char[] a = { '0', '0', '0', Character.MIN_VALUE, '0', 'O', Character.MIN_VALUE, Character.MIN_VALUE, '0', 'F' };

    static short[] b = { -19725, 32767, 32767, 0, 0, 0, -32768, -32768, 32767, 0 };

    static char c = '0';

    static short d = 32767;

    char[] test_vi_neg(char[] a, short[] b, char c, short d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4602().test_vi_neg(a, b, c, d);
    }
}
