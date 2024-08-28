public class MyJVMTest_8932 {

    static int[] iArrFld = new int[50];

    void reset() {
        for (int i = 0; i < iArrFld.length; i++) {
            iArrFld[i] = 5;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8932().reset();
    }
}
