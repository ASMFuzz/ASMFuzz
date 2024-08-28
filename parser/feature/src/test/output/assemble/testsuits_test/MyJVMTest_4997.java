public class MyJVMTest_4997 {

    static int[] a = { 1593227581, 0, -550961742, 0, 9, -652969426, 5, 2, 8, 0 };

    static int[] b = { 5, 0, -1793065041, 5, -1956843548, 3, 7, 184958150, 0, 2 };

    static int c = 2019802108;

    static int d = 1;

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
        new MyJVMTest_4997().test_2vi_unaln(a, b, c, d);
    }
}
