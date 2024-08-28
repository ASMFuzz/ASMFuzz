public class MyJVMTest_5467 {

    static String[] strArr1 = { "X&YdHrVT]~", "/]9>Iy-Nz\\", "M'@H!q;o.v", "k!TI3/^U#X", "WJ!>nX8`Qi", "IfR[&2F B[", "&fAE8F/;!r", "*>r,uY&Q+R", ":#m!S2? lX", "&i#X_b\\m=|" };

    void vMeth1(int i1) {
        int i3 = 4;
        long[] lArr = new long[N], lArr1 = new long[N];
        boolean b = (Integer.reverseBytes(i1 << 5) < (instanceCount++));
        for (int i2 = 1; i2 < 146; i2++) {
            iFld >>= (++i3);
        }
        if (b) {
            for (int i4 = 4; i4 < 218; ++i4) {
                instanceCount = iArrFld[i4 - 1];
                int i10 = 1;
                while (++i10 < 8) {
                    lArr1[i4] += 61384L;
                }
                lArr[i4 + 1] = i4;
                i3 += sFld;
            }
        }
    }

    static int N = 400;

    static long instanceCount = 727275458L;

    static int iFld = -10;

    static short sFld = -2966;

    static float fFld = 1.682F;

    static int[] iArrFld = new int[N];

    String[] mainTest(String[] strArr1) {
        vMeth1(iFld);
        for (int i19 = 2; i19 < 190; i19++) {
            int i20 = (int) instanceCount;
            instanceCount += (((i19 * i20) + i20) - fFld);
        }
        return strArr1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5467().mainTest(strArr1);
    }
}
