public class MyJVMTest_2016 {

    static char[] a = { '*', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static short[] b = { -32768, 32767, 32767, -30836, 0, 0, 0, 7192, -32768, -32768 };

    static char c = 'V';

    static short d = 0;

    char[] test_vi(char[] a, short[] b, char c, short d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2016().test_vi(a, b, c, d);
    }
}
