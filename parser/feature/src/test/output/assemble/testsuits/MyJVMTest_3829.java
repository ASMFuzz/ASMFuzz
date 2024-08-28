public class MyJVMTest_3829 {

    static long val = -9223372036854775808L;

    long testRorOrLong64Bic(long val) {
        return val & (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3829().testRorOrLong64Bic(val));
    }
}
