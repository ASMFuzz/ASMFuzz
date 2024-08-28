public class MyJVMTest_12073 {

    static short[] a = { 0, 0, -27805, -21625, 0, 32767, -25991, 0, 32767, 32767 };

    static short[] b = { -32768, 30064, 32767, 32767, 0, -32768, -32768, 32767, 0, -32768 };

    static long[] c = { 9223372036854775807L, 0, 0, 8318596373491060867L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static long[] d = { -9223372036854775808L, 0, 3809398816414936559L, -9223372036854775808L, 0, -9223372036854775808L, 9186271516618028709L, -9223372036854775808L, 4444028697251813408L, -1041968195427309167L };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12073().test_cp_alnsrc(a, b, c, d);
    }
}
