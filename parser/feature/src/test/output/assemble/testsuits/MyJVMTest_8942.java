public class MyJVMTest_8942 {

    void reset() {
        for (int i = 0; i < iArrFld.length; i++) {
            iArrFld[i] = 5;
        }
    }

    static int[] iArrFld = new int[50];

    int test4() {
        int x = 2;
        long y = 3L;
        for (int i = 50; i > 9; i--) {
            x = 2;
            for (int j = 10; j < 50; j++) {
                x += iArrFld[j];
                iArrFld[j] = (int) (y++);
            }
            reset();
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8942().test4());
    }
}
