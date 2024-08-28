public class MyJVMTest_13171 {

    static long val = 3631130223888392582L;

    long testRorOrLong64Bic(long val) {
        return val & (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13171().testRorOrLong64Bic(val));
    }
}
