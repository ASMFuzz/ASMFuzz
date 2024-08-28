public class MyJVMTest_14980 {

    static int i = 4;

    static int j = 97380568;

    static int k = -1618291347;

    static int staticField3 = 9;

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
        new MyJVMTest_14980().inlined(i, j, k);
    }
}
