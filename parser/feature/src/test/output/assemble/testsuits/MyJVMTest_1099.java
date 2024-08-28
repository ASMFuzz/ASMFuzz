public class MyJVMTest_1099 {

    static String[] strArr1 = { "F6137t5CQ:", "b/\\XY\\+9/O", "qO <U]GfCl", "\"A-Wox;cUY", "<-D`y8swfk", "~Pym.sLh{J", "X|?IAs9a}b", "\\9j$`DM/ k", "ax-EnJYMh{", "$XS`{wfKj~" };

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
        new MyJVMTest_1099().mainTest(strArr1);
    }
}
