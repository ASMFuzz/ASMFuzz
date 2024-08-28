public class MyJVMTest_6419 {

    static long val = -9223372036854775808L;

    long testRorOrLong16Orn(long val) {
        return val | (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6419().testRorOrLong16Orn(val));
    }
}
