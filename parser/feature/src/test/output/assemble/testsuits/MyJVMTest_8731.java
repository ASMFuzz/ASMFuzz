public class MyJVMTest_8731 {

    static long val = -9223372036854775808L;

    long testRorOrLong63Eon(long val) {
        return val ^ (-1 ^ ((val >>> 63) | (val << (64 - 63))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8731().testRorOrLong63Eon(val));
    }
}
