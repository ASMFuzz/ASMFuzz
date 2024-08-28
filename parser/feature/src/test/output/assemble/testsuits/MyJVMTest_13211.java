public class MyJVMTest_13211 {

    static char[] a = { Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, '0', '5', Character.MIN_VALUE, Character.MAX_VALUE, 'S', '0' };

    static char[] b = { '<', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'w', Character.MIN_VALUE, 'G', '0', Character.MAX_VALUE };

    static char c = Character.MIN_VALUE;

    static char d = 'M';

    static int SCALE = 2;

    char[] test_2vi_scl(char[] a, char[] b, char c, char d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13211().test_2vi_scl(a, b, c, d);
    }
}
