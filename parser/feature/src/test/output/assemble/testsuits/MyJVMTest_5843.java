public class MyJVMTest_5843 {

    static int[] a = { 1851414176, 2, 5, 6, 2064245938, 2147466446, 6, 0, 7, 5 };

    int[] init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = 0;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5843().init(a);
    }
}
