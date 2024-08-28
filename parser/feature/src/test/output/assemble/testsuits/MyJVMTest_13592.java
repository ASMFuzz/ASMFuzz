public class MyJVMTest_13592 {

    static long val = -9223372036854775808L;

    long testRorOrLong64Orn(long val) {
        return val | (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13592().testRorOrLong64Orn(val));
    }
}
