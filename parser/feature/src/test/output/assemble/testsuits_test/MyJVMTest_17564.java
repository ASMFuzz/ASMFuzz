public class MyJVMTest_17564 {

    static short[] a = { -32768, 18185, 29688, -32768, -32768, -32768, 28456, -16170, -32768, -11504 };

    static short[] b = { 32767, -21776, -32768, -32768, 0, 32767, 15688, -32768, -32768, -32768 };

    static short c = 0;

    static short d = -32768;

    static int ALIGN_OFF = 8;

    short[] test_2vi_aln(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17564().test_2vi_aln(a, b, c, d);
    }
}
