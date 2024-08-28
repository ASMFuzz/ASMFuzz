public class MyJVMTest_11304 {

    static int[] a = { 0, 0, 5, 5, 2, 9, 3, 981142425, 822024849, 0 };

    static int[] b = { 7, 0, 4, 0, 0, 9, 1546932702, 6, 9, 0 };

    static int[] c = { 8, -159894284, 2, 0, 6, 2, 0, 611185218, 0, 1 };

    int[] sumReductionInit(int[] a, int[] b, int[] c) {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i * 1 + j;
                b[i] = i * 1 - j;
                c[i] = i + j;
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11304().sumReductionInit(a, b, c);
    }
}
