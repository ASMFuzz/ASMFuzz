public class MyJVMTest_3868 {

    static char[] a = { '0', '0', '0', Character.MAX_VALUE, '0', Character.MAX_VALUE, '0', 'C', Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '6', 'l', Character.MIN_VALUE, '7', 'g' };

    static char c = '2';

    static char d = '0';

    static int SCALE = 2;

    char[] test_2vi_scl(char[] a, char[] b, char c, char d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3868().test_2vi_scl(a, b, c, d);
    }
}
