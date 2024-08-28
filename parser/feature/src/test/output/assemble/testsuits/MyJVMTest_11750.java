public class MyJVMTest_11750 {

    static long val = 0;

    long testRorOrLong16Or(long val) {
        return val | ((val >>> 16) | (val << (64 - 16)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11750().testRorOrLong16Or(val));
    }
}
