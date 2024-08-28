public class MyJVMTest_16788 {

    static long val = 9223372036854775807L;

    long testRorOrLong63Orn(long val) {
        return val | (-1 ^ ((val >>> 63) | (val << (64 - 63))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16788().testRorOrLong63Orn(val));
    }
}
