public class MyJVMTest_4340 {

    static int[] a = { 1344338402, 3, 9, 943433452, 8, 3, -2073942442, 0, 2, 0 };

    static int[] b = { 1, 0, 7, 0, 5, 0, 6, 772524409, 2, 0 };

    static int[] c = { -1979370152, 5, 1, 1648072904, 6, -1598225419, 6, 4, 9, 6 };

    int[] reductionInit2(int[] a, int[] b, int[] c) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0x11;
            b[i] = 0x12;
            c[i] = 0x13;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4340().reductionInit2(a, b, c);
    }
}
