public class MyJVMTest_5275 {

    static long val = 0;

    long testRorOrLong63Bic(long val) {
        return val & (-1 ^ ((val >>> 63) | (val << (64 - 63))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5275().testRorOrLong63Bic(val));
    }
}
