public class MyJVMTest_9067 {

    static long val = 0;

    long testRorAddLong63(long val) {
        return (val >>> 63) + (val << (64 - 63));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9067().testRorAddLong63(val));
    }
}
