public class MyJVMTest_1906 {

    static long diff = 0;

    long checkCurrentTimeMillis(long diff) {
        if (diff < 0) {
            throw new RuntimeException("testCurrentTimeMillis failed with " + diff);
        }
        return diff;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1906().checkCurrentTimeMillis(diff);
    }
}
