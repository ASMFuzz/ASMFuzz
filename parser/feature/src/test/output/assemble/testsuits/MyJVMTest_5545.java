public class MyJVMTest_5545 {

    static int i = 1563104534;

    static int j = 9;

    static int k = 0;

    static int staticField3 = 721576878;

    int inlined(int i, int j, int k) {
        if (i == 2) {
            if (j == 2) {
                staticField3 = 0x42;
            }
            if (k == 2) {
                staticField3 = 0x42;
            }
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5545().inlined(i, j, k);
    }
}
