public class MyJVMTest_10135 {

    static int[] a = { 9, 1225575086, 8, 8, 0, 5, 5, 2, 0, 9 };

    static int[] b = { 1933183724, 4, 2, 0, 0, 0, 0, 505173641, 1, 4 };

    static int c = 9;

    static int d = 638608543;

    static int ALIGN_OFF = 8;

    int[] test_2vi_aln(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10135().test_2vi_aln(a, b, c, d);
    }
}
