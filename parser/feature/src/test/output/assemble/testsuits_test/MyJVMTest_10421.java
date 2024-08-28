public class MyJVMTest_10421 {

    static int[] a = { 2075965126, 0, -523364352, 0, 3, -1051452058, 2, 0, -838752244, 0 };

    static int[] b = { 0, 0, 7, -713701021, 1396263627, -484393902, 6, 0, -1871668718, 5 };

    static int SCALE = 2;

    int[] test_cp_scl(int[] a, int[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10421().test_cp_scl(a, b);
    }
}
