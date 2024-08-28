public class MyJVMTest_8827 {

    static long val = 9223372036854775807L;

    long testRorOrLong16Or(long val) {
        return val | ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8827().testRorOrLong16Or(val));
    }
}
