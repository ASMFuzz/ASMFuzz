public class MyJVMTest_4226 {

    static long val = -6347464093783667127L;

    long testRorOrLong64Orn(long val) {
        return val | (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4226().testRorOrLong64Orn(val));
    }
}
