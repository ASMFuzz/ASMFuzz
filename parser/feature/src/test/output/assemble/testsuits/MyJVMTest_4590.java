public class MyJVMTest_4590 {

    static long val = 1258408225038379611L;

    long testRorOrLong64Eor(long val) {
        return val ^ ((val >>> 64) | (val << (64 - 64)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4590().testRorOrLong64Eor(val));
    }
}
