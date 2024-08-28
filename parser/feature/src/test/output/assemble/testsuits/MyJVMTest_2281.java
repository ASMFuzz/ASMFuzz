public class MyJVMTest_2281 {

    static long val = -9223372036854775808L;

    long testRorOrLong63And(long val) {
        return val & ((val >>> 63) | (val << (64 - 63)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2281().testRorOrLong63And(val));
    }
}
