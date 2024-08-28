public class MyJVMTest_15405 {

    static char[] a = { Character.MIN_VALUE, 'U', '0', Character.MAX_VALUE, Character.MAX_VALUE, 'A', '(', Character.MAX_VALUE, Character.MAX_VALUE, '(' };

    static char[] b = { '0', '0', 'N', Character.MAX_VALUE, '0', Character.MAX_VALUE, 'F', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char c = Character.MIN_VALUE;

    static char d = Character.MIN_VALUE;

    int test_2vi_oppos(char[] a, char[] b, char c, char d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15405().test_2vi_oppos(a, b, c, d);
    }
}
