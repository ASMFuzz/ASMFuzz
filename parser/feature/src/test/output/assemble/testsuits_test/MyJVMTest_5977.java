public class MyJVMTest_5977 {

    static long val = -9223372036854775808L;

    long testRorOrLong16Eon(long val) {
        return val ^ (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5977().testRorOrLong16Eon(val));
    }
}
