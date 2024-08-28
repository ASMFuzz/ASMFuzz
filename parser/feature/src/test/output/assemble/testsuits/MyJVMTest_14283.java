public class MyJVMTest_14283 {

    static long val = -6939026288732096233L;

    long testRorOrLong64Or(long val) {
        return val | ((val >>> 64) | (val << (64 - 64)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14283().testRorOrLong64Or(val));
    }
}
