public class MyJVMTest_9005 {

    static long millis = 9223372036854775807L;

    long sleepms(long millis) throws InterruptedException {
        long start = System.nanoTime();
        long ms = millis;
        while (ms > 0) {
            assert ms < Long.MAX_VALUE / 1000_000L;
            Thread.sleep(ms);
            long elapsedms = (System.nanoTime() - start) / 1000_000L;
            ms = millis - elapsedms;
        }
        return millis - ms;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9005().sleepms(millis));
    }
}
