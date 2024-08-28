public class MyJVMTest_6456 {

    static char[] a = { 'O', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, 'E', Character.MAX_VALUE, '0' };

    static char[] b = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static char c = '0';

    static char d = '0';

    static int OFFSET = 3;

    char[] test_2vi_off(char[] a, char[] b, char c, char d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6456().test_2vi_off(a, b, c, d);
    }
}
