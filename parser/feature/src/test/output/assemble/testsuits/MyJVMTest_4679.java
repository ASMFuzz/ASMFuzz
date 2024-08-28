public class MyJVMTest_4679 {

    static byte[] a = { -6, 92, -68, -126, -7, -31, -96, -44, 68, 120 };

    static byte[] b = { -40, -101, -116, 125, -121, -64, 125, 24, -115, -83 };

    static long[] c = { 0, 9223372036854775807L, 7518189747824149854L, 0, 9223372036854775807L, 0, -1812019085385307630L, 9223372036854775807L, 9223372036854775807L, 0 };

    static long[] d = { -7091912972570042427L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 740235995503764703L, -3789167593664711079L, -9223372036854775808L, -9223372036854775808L, 0 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4679().test_cp_alnsrc(a, b, c, d);
    }
}
