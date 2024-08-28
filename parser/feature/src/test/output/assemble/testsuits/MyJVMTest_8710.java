public class MyJVMTest_8710 {

    static long val = 0;

    long testRorOrLong64Or(long val) {
        return val | ((val >>> 64) | (val << (64 - 64)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8710().testRorOrLong64Or(val));
    }
}
