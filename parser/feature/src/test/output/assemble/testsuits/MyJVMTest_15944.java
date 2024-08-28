public class MyJVMTest_15944 {

    static char[] a = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'f', 'K', 'F' };

    static char[] b = { Character.MAX_VALUE, '&', Character.MAX_VALUE, 'O', Character.MAX_VALUE, Character.MIN_VALUE, 'p', '0', Character.MAX_VALUE, '4' };

    static char c = Character.MIN_VALUE;

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
        new MyJVMTest_15944().test_2vi_off(a, b, c, d);
    }
}
