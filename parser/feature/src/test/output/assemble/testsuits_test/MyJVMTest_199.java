public class MyJVMTest_199 {

    static short[] a = { -21408, -32768, 32767, 30742, -12746, -32768, 32767, -32768, -32768, -15864 };

    static short[] b = { 0, 32767, 16124, 32767, 3735, 32767, 32767, 5138, 0, 0 };

    static int ALIGN_OFF = 8;

    short[] test_2ci_aln(short[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_199().test_2ci_aln(a, b);
    }
}
