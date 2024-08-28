public class MyJVMTest_2271 {

    static byte bArg = 0;

    static int iArg = 0;

    static long lArg = -9223372036854775808L;

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
        new MyJVMTest_2271().vMeth(bArg, iArg, lArg);
    }
}
