public class MyJVMTest_4539 {

    static int N = 400;

    static long instanceCount = -154L;

    static int[] iArrFld = new int[N];

    void mainTest() {
        int i8 = 8, i9 = -3, i10 = -199, i11 = 13, i12 = 8, i13 = 2;
        long[] lArr1 = new long[N];
        for (int i7 : iArrFld) {
            for (i8 = 1; i8 < 63; ++i8) {
                i10 = 1;
                while (++i10 < 2) {
                    i7 += (int) instanceCount;
                    lArr1[i10 + 1] -= 3;
                }
                i11 = 2;
                do {
                    byte by2 = -104;
                    by2 = (byte) instanceCount;
                } while (--i11 > 0);
                i9 <<= 6;
                for (i12 = i8; 2 > i12; i12++) {
                    switch(((i11 >>> 1) % 1) + 66) {
                        case 66:
                            instanceCount -= i13;
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4539().mainTest();
    }
}
