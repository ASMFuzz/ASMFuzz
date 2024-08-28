public class MyJVMTest_13441 {

    static String[] strArr1 = { "lUH&rP6^CX", "}0*t}ZEFP?", "{4s9y*HgPT", "0?9]/qK~fD", "H2Ts}\\_Kjt", "fAp/P*_7w:", "&+/mV/{[P$", "\"QiYMYx|4P", "?Ej&B~fUEo", "'I#aKbHQt[" };

    static int N = 400;

    static long instanceCount = -94L;

    static byte byFld = -108;

    int mainTest(String[] strArr1) {
        int i17 = 9, i19 = 1, i20 = 63, i21 = -32916, i22 = 0, iArr[] = new int[N];
        boolean b1 = false;
        double d3 = 76.18241;
        for (int i : iArr) {
            for (i17 = 2; i17 < 63; i17++) {
                if (b1)
                    break;
                byFld += (byte) (0.131F + (i17 * i17));
            }
            for (i19 = 1; 63 > i19; ++i19) {
                for (i21 = 1; i21 < 2; i21++) {
                    d3 = i22;
                    if (b1)
                        continue;
                    i20 = i21;
                }
                d3 -= byFld;
                instanceCount = 46725L;
            }
            switch((((i22 >>> 1) % 4) * 5) + 91) {
                case 98:
                    break;
                case 110:
                    break;
                case 105:
                    break;
                case 103:
                    break;
                default:
            }
        }
        return i20;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13441().mainTest(strArr1));
    }
}
