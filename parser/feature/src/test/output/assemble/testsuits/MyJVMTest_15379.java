public class MyJVMTest_15379 {

    static long[] a = { 9223372036854775807L, -105804975782061403L, 0, 0, 9223372036854775807L, -9223372036854775808L, 6137162375920328706L, 9223372036854775807L, -9223372036854775808L, -5756157871321662271L };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 5850169363348129866L, 9223372036854775807L, 9223372036854775807L, 0, -7597307350107356607L, -1070577980031313066L, -4698447202927955903L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalnsrc(long[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15379().test_cp_unalnsrc(a, b);
    }
}
