public class MyJVMTest_118 {

    static long val = -9223372036854775808L;

    long testRorOrLong1And(long val) {
        return val & ((val >>> 1) | (val << (64 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_118().testRorOrLong1And(val));
    }
}
