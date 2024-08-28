public class MyJVMTest_2751 {

    static long val = 0;

    long testRorOrLong16Eor(long val) {
        return val ^ ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2751().testRorOrLong16Eor(val));
    }
}
