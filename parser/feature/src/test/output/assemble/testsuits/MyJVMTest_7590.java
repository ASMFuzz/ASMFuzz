public class MyJVMTest_7590 {

    static long val = 9223372036854775807L;

    long testRorOrLong64Eon(long val) {
        return val ^ (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7590().testRorOrLong64Eon(val));
    }
}
