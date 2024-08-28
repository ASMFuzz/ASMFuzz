public class MyJVMTest_836 {

    static long val = 9223372036854775807L;

    long testRorOrLong1Bic(long val) {
        return val & (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_836().testRorOrLong1Bic(val));
    }
}
