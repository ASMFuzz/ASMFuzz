public class MyJVMTest_11644 {

    static short[] a = { 0, 32767, -32768, -32768, -32768, 25356, 0, 27690, -31549, -31648 };

    static int[] b = { -407423686, 0, 0, -203481912, -806727808, 1729440859, -1086471813, 9, 6, 4 };

    static short c = -4236;

    static int d = 0;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_vi_unaln(short[] a, int[] b, short c, int d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11644().test_vi_unaln(a, b, c, d);
    }
}
