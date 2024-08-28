public class MyJVMTest_510 {

    static char[] a = { Character.MAX_VALUE, 'M', '0', '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', 'l', '0', '0' };

    static char b = '0';

    int test_vi_oppos(char[] a, char b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_510().test_vi_oppos(a, b);
    }
}
