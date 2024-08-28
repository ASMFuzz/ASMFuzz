public class MyJVMTest_17533 {

    static char[] a = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'V', Character.MAX_VALUE, Character.MAX_VALUE, 't', '5', '0', 'R' };

    static char[] b = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', '"', Character.MIN_VALUE, '0', '0' };

    static char c = Character.MAX_VALUE;

    static char d = '0';

    char[] test_2vi_neg(char[] a, char[] b, char c, char d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17533().test_2vi_neg(a, b, c, d);
    }
}
