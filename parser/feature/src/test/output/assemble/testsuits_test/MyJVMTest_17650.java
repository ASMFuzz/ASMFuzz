public class MyJVMTest_17650 {

    static int i1 = 0;

    static int N = 400;

    static long instanceCount = 727275458L;

    static int iFld = -10;

    static short sFld = -2966;

    static int[] iArrFld = new int[N];

    int vMeth1(int i1) {
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
        return i3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17650().vMeth1(i1);
    }
}
