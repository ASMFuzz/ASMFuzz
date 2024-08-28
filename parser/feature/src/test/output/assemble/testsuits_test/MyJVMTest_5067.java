public class MyJVMTest_5067 {

    static int[] iArrFld = new int[10];

    void test() {
        int x = 20;
        int y = 0;
        int z = 10;
        for (int i = 9; i < 99; i += 2) {
            for (int j = 3; j < 100; j++) {
                for (int k = 1; k < 2; k++) {
                    try {
                        x = (-65229 / y);
                        z = (iArrFld[5] / 8);
                    } catch (ArithmeticException a_e) {
                    }
                    try {
                        y = (-38077 / y);
                        z = (y / 9);
                    } catch (ArithmeticException a_e) {
                    }
                    y = 8;
                    z += k;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5067().test();
    }
}
