public class MyJVMTest_11850 {

    static long val = 0;

    long testRorOrLong1Orn(long val) {
        return val | (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11850().testRorOrLong1Orn(val));
    }
}
