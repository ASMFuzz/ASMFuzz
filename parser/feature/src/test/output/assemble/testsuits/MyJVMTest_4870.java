public class MyJVMTest_4870 {

    void m(int i4) {
        i4 |= -104;
        iArrFld[(i4 >>> 1) % N] >>= i4;
    }

    static int N = 400;

    static int[] iArrFld = new int[N];

    void test() {
        int i2 = 1, i24 = 65;
        for (int i1 = 7; i1 < 384; ++i1) {
            for (long l = 2; l < 67; l++) {
                m(i2);
                for (i24 = 1; 2 > i24; ++i24) {
                    iArrFld = iArrFld;
                }
            }
            i2 = (-229 / i24);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4870().test();
    }
}
