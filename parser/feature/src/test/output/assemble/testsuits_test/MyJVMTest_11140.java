public class MyJVMTest_11140 {

    static long diff = -7234081498285807344L;

    long checkCurrentTimeMillis(long diff) {
        if (diff < 0) {
            throw new RuntimeException("testCurrentTimeMillis failed with " + diff);
        }
        return diff;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11140().checkCurrentTimeMillis(diff);
    }
}
