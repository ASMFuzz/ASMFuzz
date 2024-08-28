public class MyJVMTest_9110 {

    static long val = -9223372036854775808L;

    long testRorOrLong1Orn(long val) {
        return val | (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9110().testRorOrLong1Orn(val));
    }
}
