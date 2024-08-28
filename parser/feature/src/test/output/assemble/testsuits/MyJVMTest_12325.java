public class MyJVMTest_12325 {

    static int[] a = { 3, 1547645871, 2, 8, 0, 1050002020, 0, 2122677825, 9, 5 };

    static int b = 2;

    int[] test_vi(int[] a, int b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12325().test_vi(a, b);
    }
}
