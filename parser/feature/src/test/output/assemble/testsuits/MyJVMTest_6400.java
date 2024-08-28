public class MyJVMTest_6400 {

    void vMeth(byte bArg, int iArg, long lArg) {
        int i = N - 1;
        do {
            iArr[i - 1] += iArg;
            iArr[i] += iArg;
            lArr[i - 1] = lArg;
            bArr[i - 1] = bArg;
        } while (--i > 0);
    }

    static int N = 400;

    static byte[] bArr = new byte[N];

    static int[] iArr = new int[N];

    static long[] lArr = new long[N];

    void mainTest() {
        byte b = 0;
        int i = 0;
        long l = 0;
        for (int j = 0; j < N; ++j) {
            vMeth(b, i, l);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6400().mainTest();
    }
}
