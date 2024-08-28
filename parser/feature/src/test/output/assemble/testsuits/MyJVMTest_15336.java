public class MyJVMTest_15336 {

    static int[] a = { -349840229, 8, 0, 314247575, 2, -97409120, 5, 1083376133, 3, 1 };

    static int[] b = { 1053167345, 0, 0, 5, 8, 1, 0, 0, 6, 2045707434 };

    static int[] c = { 2, 7, 1, 8, 431575557, 4, 0, 6, -925832585, 1 };

    int[] reductionInit1(int[] a, int[] b, int[] c) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (i % 2) + 0x4099;
            b[i] = (i % 2) + 0x1033;
            c[i] = (i % 2) + 0x455;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15336().reductionInit1(a, b, c);
    }
}
