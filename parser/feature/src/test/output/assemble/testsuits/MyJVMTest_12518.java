public class MyJVMTest_12518 {

    static int x = 0;

    static int y = 20;

    static boolean bFld = true;

    static int iFld = 20;

    static float[] fArrFld = new float[50];

    void test5() {
        int j = 50;
        int i = 1;
        while (++i < 40) {
            j = 5;
            do {
                fArrFld[i] = 46;
                iFld = 5;
                if (bFld)
                    break;
            } while (++j < 5);
            j = 2;
            do {
                try {
                    iFld = 56;
                } catch (ArithmeticException a_e) {
                }
                if (bFld)
                    break;
            } while (++j < 2);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12518().test5();
    }
}
