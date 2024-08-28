public class MyJVMTest_3887 {

    static long val = -9223372036854775808L;

    long testRorOrLong16(long val) {
        return (val >>> 16) | (val << (64 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3887().testRorOrLong16(val));
    }
}
