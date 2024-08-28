public class MyJVMTest_10514 {

    void init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = 0;
        }
    }

    void doNothing() {
    }

    static int iFld = 0;

    static short sFld = 1;

    int test() {
        int x = 11;
        int y = 0;
        int j = 0;
        int[] iArr = new int[400];
        init(iArr);
        for (int i = 0; i < 2; i++) {
            doNothing();
            for (j = 10; j > 1; j -= 2) {
                sFld += (short) j;
                iArr = iArr;
                y += (j * 3);
                x = (iArr[j - 1] / x);
                x = sFld;
            }
            int k = 1;
            while (++k < 8) {
                iFld += x;
            }
        }
        return Float.floatToIntBits(654) + x + j + y;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10514().test());
    }
}
