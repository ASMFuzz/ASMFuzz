public class MyJVMTest_10294 {

    static String[] strArr1 = { "Wv*&jt?^xv", "K-stf6tQ '", "*Y`?n[6Ii4", "M-//U2|ZPd", "5P?,kHjjLG", "DG$$47fy@9", "(q7A&zAG0\\", "1B=>BQ,f')", "Z+0|\\3x5a[", "9hFp1R)gLG" };

    static int N = 400;

    static long instanceCount = -4622920139809038929L;

    int mainTest(String[] strArr1) {
        int i1 = -211, i20 = 54720, i21 = 205, i22 = 2184, i23 = 58, i24 = -50110, iArr3[] = new int[N];
        for (i20 = 16; 331 > i20; ++i20) {
            i1 = i20;
            i21 += i1;
            iArr3[i20] <<= (int) StripMinedLoopReorgOffsets.instanceCount;
            for (i22 = 4; i22 < 80; i22++) {
                i21 = i23;
                i24 = 1;
                while (++i24 < 2) {
                    try {
                        iArr3[i22] = (i23 / i1);
                    } catch (ArithmeticException a_e) {
                    }
                }
            }
        }
        System.out.println("i1 i20 = " + i1 + "," + i20);
        System.out.println("i21 i22 i23 = " + i21 + "," + i22 + "," + i23);
        System.out.println("i24 = " + i24);
        return i20;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10294().mainTest(strArr1);
    }
}
