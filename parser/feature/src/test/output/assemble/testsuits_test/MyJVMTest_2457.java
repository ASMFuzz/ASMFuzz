public class MyJVMTest_2457 {

    static int[] iArrFld = new int[400];

    void test() {
        int i = 56, i2 = 22257;
        do {
            do {
                int i24 = 1;
                while (++i24 < 2) {
                }
                for (long l1 = i; l1 < 2; ++l1) {
                    iArrFld[0] += 5;
                }
            } while ((i2 -= 2) > 0);
            for (long l3 = 8; l3 < 194; ++l3) {
            }
        } while (--i > 0);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2457().test();
    }
}
