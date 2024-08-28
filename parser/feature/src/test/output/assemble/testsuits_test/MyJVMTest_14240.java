public class MyJVMTest_14240 {

    static int x = 1;

    static int[] iArrFld = new int[400];

    void test() {
        int i6, i7 = 9, i8, i9 = 138;
        for (i6 = 7; i6 > 1; i6 -= 3) {
            for (i8 = i6; i8 < 4; i8++) {
                try {
                    iArrFld[i8] = (52691 / i8);
                    i7 = (iArrFld[i8 + 1] % i9);
                    i7 = (412419036 / iArrFld[i8]);
                } catch (ArithmeticException a_e) {
                }
                i9 += 13;
            }
        }
        x = i7;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14240().test();
    }
}
