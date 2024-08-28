public class MyJVMTest_8839 {

    static long val = 4019089779729747883L;

    long testRorOrLong64Orn(long val) {
        return val | (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8839().testRorOrLong64Orn(val));
    }
}
