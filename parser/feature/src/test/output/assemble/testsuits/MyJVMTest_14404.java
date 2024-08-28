public class MyJVMTest_14404 {

    static int[] a = { 0, 0, 0, 1005495067, 5, -1702812969, 7, 924638691, -1718119127, 0 };

    static int[] b = { 0, 1150519093, 0, 0, -2012418624, 0, 6, 2, 0, 8 };

    static int c = 4;

    static int d = 0;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_2vi_unaln(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14404().test_2vi_unaln(a, b, c, d);
    }
}
