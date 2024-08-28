public class MyJVMTest_11528 {

    static byte bArg = -128;

    static int iArg = 5;

    static long lArg = 0;

    static int N = 400;

    static byte[] bArr = new byte[N];

    static int[] iArr = new int[N];

    static long[] lArr = new long[N];

    int vMeth(byte bArg, int iArg, long lArg) {
        int i = N - 1;
        do {
            iArr[i - 1] += iArg;
            iArr[i] += iArg;
            lArr[i - 1] = lArg;
            bArr[i - 1] = bArg;
        } while (--i > 0);
        return iArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11528().vMeth(bArg, iArg, lArg);
    }
}
