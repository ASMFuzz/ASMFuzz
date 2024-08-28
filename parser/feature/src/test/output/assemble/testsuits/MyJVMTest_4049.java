public class MyJVMTest_4049 {

    static int[] a = { 1, 0, 0, 1, 0, 1993970763, 0, -2019762438, 2, 0 };

    static int[] b = { 1398982261, 0, 0, 1012427525, 2, 1946164640, 1386371373, 8, 0, 0 };

    int[] test_2ci_oppos(int[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4049().test_2ci_oppos(a, b);
    }
}
