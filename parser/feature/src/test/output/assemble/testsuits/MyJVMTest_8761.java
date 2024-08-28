public class MyJVMTest_8761 {

    void reset() {
        for (int i = 0; i < iArrFld.length; i++) {
            iArrFld[i] = 5;
        }
    }

    static int[] iArrFld = new int[50];

    int test() {
        int x = 2;
        for (int i = 50; i > 9; i--) {
            x = 2;
            for (int j = 10; j < 50; j++) {
                x += iArrFld[j];
                iArrFld[j] = j;
            }
            reset();
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8761().test());
    }
}
