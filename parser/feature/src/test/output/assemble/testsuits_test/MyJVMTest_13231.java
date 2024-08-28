public class MyJVMTest_13231 {

    static long val = -8669715536262621136L;

    long testRorOrLong16(long val) {
        return (val >>> 16) | (val << (64 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13231().testRorOrLong16(val));
    }
}
