public class MyJVMTest_7096 {

    static long diff = -2894738434196394752L;

    long checkNanoTime(long diff) {
        if (diff < 0) {
            throw new RuntimeException("testNanoTime failed with " + diff);
        }
        return diff;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7096().checkNanoTime(diff);
    }
}
