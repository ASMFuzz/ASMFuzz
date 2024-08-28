public class MyJVMTest_17549 {

    static char[] a = { 'v', '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '*' };

    static short[] b = { 0, -24188, 0, 32767, 0, 0, 32767, -11345, -12008, 32767 };

    static char c = Character.MIN_VALUE;

    static short d = -32768;

    char[] test_vi_oppos(char[] a, short[] b, char c, short d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17549().test_vi_oppos(a, b, c, d);
    }
}
