public class MyJVMTest_15432 {

    static long val = -8239384789344508309L;

    long testRorOrLong16Eon(long val) {
        return val ^ (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15432().testRorOrLong16Eon(val));
    }
}
