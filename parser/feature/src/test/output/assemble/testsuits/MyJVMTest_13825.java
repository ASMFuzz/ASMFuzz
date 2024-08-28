public class MyJVMTest_13825 {

    static long val = -8853853617982670838L;

    long testRorOrLong63Eor(long val) {
        return val ^ ((val >>> 63) | (val << (64 - 63)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13825().testRorOrLong63Eor(val));
    }
}
