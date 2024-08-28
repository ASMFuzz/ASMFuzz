public class MyJVMTest_3850 {

    void reset() {
        for (int i = 0; i < iArrFld.length; i++) {
            iArrFld[i] = 5;
        }
    }

    static int[] iArrFld = new int[50];

    int test3() {
        int x = 2;
        for (int i = 50; i > 9; i--) {
            x = 2;
            int y = i;
            for (int j = 10; j < 50; j++) {
                y++;
                x += iArrFld[j];
                iArrFld[j] = y;
            }
            reset();
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3850().test3());
    }
}
