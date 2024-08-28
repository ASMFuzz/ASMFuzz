public class MyJVMTest_8280 {

    static String[] strArr1 = { "$h@O=<9yN6", "{@M)#b%$hC", "g3{BwJ1;+0", "zQ@:-&Cu8>", "\\(wwL>OItH", "bX61_ALr@U", "y&>~~&yUu$", "{WGdI0a56<", "yikS]ch7F|", ".S0 _bD:r]" };

    static int N = 400;

    static int[] iArrFld = new int[N];

    int mainTest(String[] strArr1) {
        int i = 57657, i1 = 577, i2 = 6, i3 = 157, i4 = 12, i23 = 61271;
        boolean[] bArr = new boolean[N];
        for (i = 9; 379 > i; i++) {
            i2 = 1;
            do {
                i1 <<= i3;
            } while (++i2 < 68);
            for (i23 = 68; i23 > 3; i23--) {
                bArr[i23 + 1] = true;
                try {
                    i1 = (-42360 / i23);
                    iArrFld[i + 1] = (i4 % 15384);
                } catch (ArithmeticException a_e) {
                }
            }
        }
        return i23;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8280().mainTest(strArr1);
    }
}
