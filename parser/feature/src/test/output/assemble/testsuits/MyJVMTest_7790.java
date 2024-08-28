public class MyJVMTest_7790 {

    static char[] a = { Character.MAX_VALUE, 'G', '0', '0', 'U', '0', Character.MIN_VALUE, 'y', 'W', Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'Z', Character.MAX_VALUE, '0' };

    static short[] c = { 32767, -32768, 790, 32767, 21762, -32768, 32767, 32767, 32767, 0 };

    static short[] d = { 32767, 27861, -32768, -32768, 0, 12669, 0, 0, 0, 0 };

    char[] test_cp_oppos(char[] a, char[] b, short[] c, short[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7790().test_cp_oppos(a, b, c, d);
    }
}
