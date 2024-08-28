public class MyJVMTest_15 {

    static char[] a = { Character.MIN_VALUE, '0', '0', 'Y', 'b', '0', Character.MIN_VALUE, Character.MIN_VALUE, 'J', '0' };

    static char[] b = { 'A', 't', Character.MIN_VALUE, '0', 'D', Character.MAX_VALUE, Character.MIN_VALUE, '5', '0', Character.MAX_VALUE };

    static short[] c = { -3943, -4767, 0, 24362, 7272, -16019, 32767, 32767, -2820, 0 };

    static short[] d = { 32767, 32767, 32767, 614, -32768, -32768, -736, -32768, 32767, 0 };

    char[] test_cp(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15().test_cp(a, b, c, d);
    }
}
