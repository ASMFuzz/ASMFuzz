public class MyJVMTest_7969 {

    static char[] a = { Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '^', Character.MIN_VALUE, '\\', Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] b = { 'e', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', 'm', 'l' };

    static char c = Character.MAX_VALUE;

    static char d = '2';

    char[] test_2vi_neg(char[] a, char[] b, char c, char d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7969().test_2vi_neg(a, b, c, d);
    }
}
