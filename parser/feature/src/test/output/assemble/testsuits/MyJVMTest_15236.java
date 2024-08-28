public class MyJVMTest_15236 {

    static int[] a = { 4, 4, 0, 410825931, -2099197113, 9, 929804486, 1944784959, 2, 0 };

    static int b = 0;

    static int OFFSET = 3;

    int[] test_vi_off(int[] a, int b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15236().test_vi_off(a, b);
    }
}
