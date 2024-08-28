public class MyJVMTest_17856 {

    static String[] strArr1 = { "8SvEpcA,JK", "Z9k(?Z(/.E", "\\v-*qCAR(b", "~_E40d`tQ7", " TwN%Ko4s!", "OLlc#[\"0TW", "#}\"s?UbmKB", "L.+IlYmbyV", "tM&2EQ\\~ho", "<lu#Nlw`u[" };

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
        new MyJVMTest_17856().mainTest(strArr1);
    }
}
