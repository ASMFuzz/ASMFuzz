public class MyJVMTest_9152 {

    static char[] a = { Character.MAX_VALUE, Character.MIN_VALUE, '0', 's', 'L', 'Z', 'i', '0', '0', 'P' };

    static char[] b = { '0', Character.MIN_VALUE, Character.MIN_VALUE, 'x', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'G', '5' };

    static short[] c = { -11915, -32768, 18300, 32767, 32767, 0, -10616, -32768, 32767, -32768 };

    static short[] d = { -11625, 32767, 32767, 32767, 0, 0, 32767, 2222, -32768, 27188 };

    char[] test_cp(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9152().test_cp(a, b, c, d);
    }
}
