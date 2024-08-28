public class MyJVMTest_8977 {

    static long val = -9223372036854775808L;

    long testRorOrLong16Eor(long val) {
        return val ^ ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8977().testRorOrLong16Eor(val));
    }
}
