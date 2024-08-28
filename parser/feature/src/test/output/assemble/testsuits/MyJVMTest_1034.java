public class MyJVMTest_1034 {

    static int i2 = 0;

    static int N = 0;

    static long vMeth_check_sum = 9223372036854775807L;

    int vMeth(int i2) {
        double d = 1.74287;
        int i3 = -36665, i4, iArr[] = new int[N];
        short s;
        long[] lArr = new long[N];
        while (++i3 < 132) {
            if (i2 != 0) {
                vMeth_check_sum += i3;
                return;
            }
            i4 = 1;
            while (++i4 < 12) {
                i2 += i4;
            }
        }
        vMeth_check_sum += i3;
        return i4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1034().vMeth(i2);
    }
}
