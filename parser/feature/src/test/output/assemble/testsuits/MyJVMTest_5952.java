public class MyJVMTest_5952 {

    static char[] a = { '0', '0', Character.MIN_VALUE, 'x', Character.MIN_VALUE, Character.MIN_VALUE, 'y', '5', Character.MIN_VALUE, '0' };

    static char[] b = { '0', 'l', '0', Character.MAX_VALUE, Character.MAX_VALUE, 'w', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE };

    static char c = Character.MAX_VALUE;

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
        new MyJVMTest_5952().test_2vi_oppos(a, b, c, d);
    }
}
