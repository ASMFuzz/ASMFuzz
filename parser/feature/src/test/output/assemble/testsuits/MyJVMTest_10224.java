public class MyJVMTest_10224 {

    static int i2 = 0;

    static int N = 2027123746;

    static long vMeth_check_sum = -9223372036854775808L;

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
        new MyJVMTest_10224().vMeth(i2);
    }
}
