public class MyJVMTest_14344 {

    static long val = 9223372036854775807L;

    long testRorOrLong16Bic(long val) {
        return val & (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14344().testRorOrLong16Bic(val));
    }
}
