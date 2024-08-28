public class MyJVMTest_18017 {

    static long[] a = { -9223372036854775808L, 0, 0, 0, -4106985390884622237L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { -9223372036854775808L, 3730699335506951539L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 0, 8012870714118651888L, 514925866820883510L };

    static int SCALE = 2;

    long[] test_cp_scl(long[] a, long[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18017().test_cp_scl(a, b);
    }
}
