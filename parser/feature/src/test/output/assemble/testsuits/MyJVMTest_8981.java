public class MyJVMTest_8981 {

    static long val = 0;

    long testRorOrLong64Eon(long val) {
        return val ^ (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8981().testRorOrLong64Eon(val));
    }
}
