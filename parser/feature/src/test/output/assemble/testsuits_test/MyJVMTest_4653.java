public class MyJVMTest_4653 {

    static long val = 0;

    long testRorOrLong1Eon(long val) {
        return val ^ (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4653().testRorOrLong1Eon(val));
    }
}
