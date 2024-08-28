public class MyJVMTest_8389 {

    static char[] a = { '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'N', Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, '0', Character.MIN_VALUE, 'A', 'H', '.', Character.MIN_VALUE, '0', Character.MIN_VALUE, '#' };

    static char c = Character.MAX_VALUE;

    static char d = '0';

    char[] test_2vi(char[] a, char[] b, char c, char d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8389().test_2vi(a, b, c, d);
    }
}
