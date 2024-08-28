public class MyJVMTest_11907 {

    static long val = -9223372036854775808L;

    long testRorOrLong1(long val) {
        return (val >>> 1) | (val << (64 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11907().testRorOrLong1(val));
    }
}
