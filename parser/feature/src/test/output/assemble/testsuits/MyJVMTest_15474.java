public class MyJVMTest_15474 {

    static int[] a = { 0, 7, 0, 5, -852978378, 0, 0, 7, -1993606759, 0 };

    static int[] b = { 4, 0, 5, 0, 0, 0, -1971345605, -1905550182, 4, 3 };

    static int OFFSET = 3;

    int[] test_cp_off(int[] a, int[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15474().test_cp_off(a, b);
    }
}
