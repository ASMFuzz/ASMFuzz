public class MyJVMTest_9059 {

    static long val = 0;

    long testRorOrLong63Or(long val) {
        return val | ((val >>> 63) | (val << (64 - 63)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9059().testRorOrLong63Or(val));
    }
}
