public class MyJVMTest_11257 {

    static char[] a = { 'I', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '2', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static short[] b = { 32767, -7396, 0, 4206, 32767, 0, 265, -32768, -21364, 32767 };

    static char c = Character.MIN_VALUE;

    static short d = -32768;

    char[] test_vi(char[] a, short[] b, char c, short d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11257().test_vi(a, b, c, d);
    }
}
