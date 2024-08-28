public class MyJVMTest_10015 {

    static long val = -9223372036854775808L;

    long testRorOrLong1Bic(long val) {
        return val & (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10015().testRorOrLong1Bic(val));
    }
}
