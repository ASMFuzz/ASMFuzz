public class MyJVMTest_8825 {

    static long val = -9223372036854775808L;

    long testRorOrLong1And(long val) {
        return val & ((val >>> 1) | (val << (64 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8825().testRorOrLong1And(val));
    }
}
