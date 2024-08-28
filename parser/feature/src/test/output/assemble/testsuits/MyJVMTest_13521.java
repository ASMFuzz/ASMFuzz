public class MyJVMTest_13521 {

    static int[] a = { 0, 3, -588013143, 2, 0, 8, 9, 6, 5, 1 };

    static int[] b = { 541218472, 6, -169994608, 0, 8, 0, 4, 0, 0, 0 };

    int[] prodReductionInit(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 2;
            b[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13521().prodReductionInit(a, b);
    }
}
