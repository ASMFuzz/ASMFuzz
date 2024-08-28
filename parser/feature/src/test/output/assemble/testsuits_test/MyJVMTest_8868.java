public class MyJVMTest_8868 {

    void init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = j;
        }
    }

    static int iFld = 0, iFld2 = 4, iFld3 = 1, iFld4 = 1;

    static long instanceCount = 0;

    static double dFld = 0d;

    static boolean bFld = true;

    static int[] iArrFld = new int[10];

    void testWithDiamondComplex() {
        int i, i2 = 10, i21, i22, i24, i26 = 41724, iArr2[] = new int[10];
        double d;
        float f2;
        init(iArr2);
        i = 1;
        while (++i < 219) {
            for (d = 15; 305 > d; ++d) {
                if (bFld) {
                    instanceCount = i2;
                    i2 += 4;
                    float l = (float) i2;
                    i2 = (int) ((l + 3) - (l + iFld));
                    double d1 = (double) i2;
                    i2 = (int) ((d1 + 3) - (d1 + iFld) - (d1 * iFld2));
                    i2 = (int) ((l + 3) - (l + iFld) - (l * iFld2) + (d1 - iFld2) + (d1 / iFld3));
                    d1 = (double) i2;
                    i2 = (int) ((d1 + 3) - (d1 + iFld) - (d1 * iFld2) + (d1 - iFld2) + (d1 / iFld3));
                    i2 += dFld;
                    l = (float) i2;
                    i2 = (int) ((l + 3) - (l + iFld) - (l * iFld2) + (d1 - iFld2) + (d1 / iFld3) - (d1 + iFld) - (d1 * iFld2) + (d1 - iFld2) + (d1 / iFld3));
                    d1 = (double) i2;
                    i2 = (int) ((d1 + 3) - (d1 + iFld) - (d1 * iFld2) + (d1 - iFld2) + (d1 / iFld3) + (d1 + 3) - (d1 + iFld) - (d1 * iFld2) + (d1 - iFld2) + (d1 / iFld3));
                    d1 = (double) i2;
                    i2 = (int) ((d1 + 3 + iFld2 + iFld3 + iFld4) - (d1 + iFld));
                }
                for (f2 = 5; 87 > f2; ++f2) {
                    i2 = (int) instanceCount;
                    for (i22 = 1; 2 > i22; i22++) {
                        if (bFld) {
                            iArr2[1] += 190L;
                        }
                    }
                    for (i24 = 1; 2 > i24; i24++) {
                        switch(i) {
                            case 88:
                                i26 += (i24);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8868().testWithDiamondComplex();
    }
}
