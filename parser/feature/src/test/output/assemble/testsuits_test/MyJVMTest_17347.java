public class MyJVMTest_17347 {

    static char[] a = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, 'P', Character.MAX_VALUE, '&', 'v' };

    static char[] b = { '0', Character.MIN_VALUE, 'K', Character.MIN_VALUE, '%', '=', '0', '0', '>', Character.MAX_VALUE };

    static short[] c = { -32768, -32768, -32768, 0, 0, -32768, 0, -32768, -32768, 32767 };

    static short[] d = { 307, -32768, 0, 32767, 32767, -32768, -19875, 32767, -30149, 4924 };

    char[] test_cp_oppos(char[] a, char[] b, short[] c, short[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17347().test_cp_oppos(a, b, c, d);
    }
}
