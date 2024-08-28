public class MyJVMTest_13992 {

    static char[] a = { '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'b' };

    static short[] b = { -4611, 32767, 0, -18077, 21258, -17945, 0, 32767, -16173, -32768 };

    static char c = '.';

    static short d = 0;

    char[] test_vi_neg(char[] a, short[] b, char c, short d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13992().test_vi_neg(a, b, c, d);
    }
}
