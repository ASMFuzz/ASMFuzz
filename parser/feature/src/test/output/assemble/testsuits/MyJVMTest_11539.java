public class MyJVMTest_11539 {

    static long val = 0;

    long testRorOrLong63And(long val) {
        return val & ((val >>> 63) | (val << (64 - 63)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11539().testRorOrLong63And(val));
    }
}
