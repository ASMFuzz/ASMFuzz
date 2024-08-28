public class MyJVMTest_14888 {

    static Thread[] threads = { null, null, null, null, null, null, null, null, null, null };

    static long payload1 = 0;

    static long payload2 = 3300385401761811046L;

    static long payload3 = 9223372036854775807L;

    static long payload4 = -342730135487935988L;

    Thread[] joinThreads(Thread[] threads) throws Exception {
        for (int i = 0; i < threads.length; i++) {
            try {
                if (threads[i] != null) {
                    threads[i].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return threads;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14888().joinThreads(threads);
    }
}
