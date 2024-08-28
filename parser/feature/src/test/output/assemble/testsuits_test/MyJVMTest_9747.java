public class MyJVMTest_9747 {

    static long val = 6967972304511649186L;

    long testRorAddLong63(long val) {
        return (val >>> 63) + (val << (64 - 63));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9747().testRorAddLong63(val));
    }
}
