public class MyJVMTest_16753 {

    static int i5 = 168, iFld = 2, x = 7, y = 0;

    static boolean b = false, b2 = false;

    void test() {
        for (int i = 0; i < 2480; i++) {
            int i2 = -37052, i3 = 39651, i4 = -37052;
            int i5 = 168, i6 = -133, i7 = 1, i8 = -10;
            double d = -20.82293;
            float[] fArr = new float[400];
            for (int j = 0; j < 400; j++) {
                fArr[j] = (j % 2 == 0) ? 0.300F + j : 0.300F - j;
            }
            while (--i5 > 0) {
                i6 = 1;
                do {
                    i4 += (((i6 * i2) + i3) - i3);
                    i2 += i4;
                } while (++i6 < 9);
                i3 -= i4;
                for (i7 = 1; i7 < 18; i7++) {
                    i4 = i5;
                    d -= i4;
                    i2 -= i8;
                    i2 = i8;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16753().test();
    }
}
