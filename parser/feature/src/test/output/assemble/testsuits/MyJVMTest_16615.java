public class MyJVMTest_16615 {

    static long diff = -9223372036854775808L;

    long checkNanoTime(long diff) {
        if (diff < 0) {
            throw new RuntimeException("testNanoTime failed with " + diff);
        }
        return diff;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16615().checkNanoTime(diff);
    }
}
