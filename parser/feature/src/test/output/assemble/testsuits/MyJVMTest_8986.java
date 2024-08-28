public class MyJVMTest_8986 {

    static long val = 9223372036854775807L;

    long testRorOrLong16Eon(long val) {
        return val ^ (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8986().testRorOrLong16Eon(val));
    }
}
